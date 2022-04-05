package com.gabriel.licona.valdez.demo.controller;


import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gabriel.licona.valdez.demo.model.Vacante;
import com.gabriel.licona.valdez.demo.servicee.IntServiceCategorias;
import com.gabriel.licona.valdez.demo.servicee.IntVacantes;
import com.gabriel.licona.valdez.demo.util.Utileria;


@Controller
@RequestMapping("/vacantes")
public class VacantesController {

	@Autowired
	private IntVacantes serviceVacantes;
	@Autowired
	private IntServiceCategorias serviceCategoria;
	
	@GetMapping("/index")
	public String mostraIndex(Model model ) {
		List<Vacante> vacantes = new LinkedList<Vacante>();
		vacantes = serviceVacantes.obtenerTodos();
		
		for(Vacante v : vacantes) {
			System.out.println(v);
		}
		model.addAttribute("total",serviceVacantes.obtenerTodos().size());
		model.addAttribute("vacantes", vacantes);
		return "vacantes/listaVacantes";
		}
	@GetMapping("/consulta")
	public String consulta(@RequestParam("id") int idVacante, Model model) {
		Vacante vacante = serviceVacantes.buscarPorId(idVacante);
		model.addAttribute("categorias", serviceCategoria.obtenerCategoria());
		model.addAttribute("vacante", vacante);
		return "vacantes/formVacante";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarVacante(@PathVariable("id") int IdVacante, RedirectAttributes atributo) {
		atributo.addFlashAttribute("msg","�La categoria se elimino con exito!");
		//System.out.println("id : " + IdVacante);
		serviceVacantes.eliminar(IdVacante);
		return "redirect:/vacantes/indexPaginate";
	}
	
	@GetMapping("/nueva")
	public String nuevaCategoria( Vacante vacante, Model model) {
		model.addAttribute("categorias", serviceCategoria.obtenerCategoria());
		return "/vacantes/formVacantes";
		
	}
	
	@GetMapping("/detalle")
	public String mostradetalle(Model model, @RequestParam("id") Integer IdVacante) {
		Vacante va = new Vacante();
		va = serviceVacantes.buscarPorId(IdVacante);
		model.addAttribute("vacante", va);
		return "/vacantes/detalle";
	}
	
	/*@PostMapping("/guardar")
	public String guardar(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion , 
			@RequestParam("fecha") String fecha ,@RequestParam("salario") Double salario,@RequestParam("estatus") String estatus,
			@RequestParam("destacado") Integer destacado, @RequestParam("detalle") String detalle) {
		Vacante va = new Vacante();
		int id = serviceVacantes.obtenerTodos().size();
		System.out.println(id);
		va.setId(++id);
		va.setNombre(nombre);
		va.setDescripcion(descripcion);
		va.setFecha(fecha);
		va.setSalario(salario);
		va.setDestacado(destacado);
		va.setEstatus(estatus);
		va.setDetalles(detalle);
		serviceVacantes.agregar(va);
		return "redirect:/vacantes/index";
	}*/
	
	@PostMapping("/guardar2")
	public String guardar2(Vacante vacante, BindingResult result, RedirectAttributes attributes, @RequestParam("archivoImagen") MultipartFile multiPart) {
		if (result.hasErrors()) {
			for (ObjectError error: result.getAllErrors()){
				System.out.println("Ocurrio un error: "+ error.getDefaultMessage());
				}
			return "vacantes/formVacantes";
		}
		if (!multiPart.isEmpty()) {
			String ruta = "C:\\empleos\\img-vacantes\\"; // Windows
			String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
			if (nombreImagen != null){
			vacante.setImagen(nombreImagen);
			}}
		
		int id = serviceVacantes.obtenerTodos().size();
		Vacante c = serviceVacantes.obtenerTodos().get(id-1);
		System.out.println(id);
		vacante.setId(++id);
		/*c.setId(++id);
		c.setNombre(vacante.getNombre());
		c.setDescripcion(descripcion);
		cat.setFecha(fecha);
		cat.setSalario(salario);
		*/
		vacante.setCategoria(serviceCategoria.buscarPorId(vacante.getCategoria().getId()));
		System.out.println(vacante);
		attributes.addFlashAttribute("msg", "Registro Guardado");
		serviceVacantes.agregar(vacante);
		return "redirect:/vacantes/indexPaginate";
	}
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
		@Override
		public void setAsText(String text) throws IllegalArgumentException{
			setValue(LocalDate.parse(text, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		}
		
		@Override
		public String getAsText() throws IllegalArgumentException{
			return DateTimeFormatter.ofPattern("dd-MM-yyyy").format((LocalDate) getValue());
		}
	});
}
	@ModelAttribute
	public void setGenerico(Model model) {
		model.addAttribute("categorias", serviceCategoria.obtenerCategoria());
		model.addAttribute("vacantes", serviceVacantes.obtenerTodos());
	}
	
	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
	Page<Vacante> lista = serviceVacantes.buscarTodas(page);
	model.addAttribute("total", serviceVacantes.buscarTodas(page));
	model.addAttribute("vacantes", lista);
	return "vacantes/listaVacantes";
	}
	
}	
