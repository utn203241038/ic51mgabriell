package com.gabriel.licona.valdez.demo.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gabriel.licona.valdez.demo.model.Categoria;
import com.gabriel.licona.valdez.demo.servicee.IntServiceCategorias;
@Controller
@RequestMapping("/categorias")
public class CategoriasController {
	
	@Autowired
	private IntServiceCategorias serviceCategorias;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Categoria> lista = new LinkedList<Categoria>();
		lista = serviceCategorias.obtenerCategoria();
		for(Categoria c: lista) {
			System.out.println(c);
		}
		model.addAttribute("total", serviceCategorias.obtenerCategoria().size());
		model.addAttribute("categorias", lista);
		return "categorias/listaCategoria";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarcategoria(@PathVariable("id")int idCategoria, RedirectAttributes atributo) {
		atributo.addFlashAttribute("msg","�La categoria se elimino con exito!");
		serviceCategorias.eliminar(idCategoria);
		return "redirect:/categorias/indexPaginate";
	}

	@GetMapping("/nueva")
	public String nuevaCategoria() {
		return "/categorias/formCategoria";
	}

	/*@PostMapping("/guardar")
	public String guardar(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion) {
		Categoria cat = new Categoria();
		int id = serviceCategorias.obtenerCategoria().size();
		System.out.println(id);
		cat.setId(++id);
		cat.setNombre(nombre);
		cat.setDescripcion(descripcion);
		serviceCategorias.guardar(cat);
		return "redirect:/categorias/indexPaginate";
	}
	*/
	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
	Page<Categoria>lista = serviceCategorias.buscarTodos(page);
	model.addAttribute("total",serviceCategorias.numeroCategoria());
	model.addAttribute("categorias", lista);
	return "categorias/listaCategoria";
	}

	@GetMapping("/consulta")
	public String consulta (@RequestParam("id") int idCategoria, Model model) {
		
		Categoria categoria= serviceCategorias.buscarPorId(idCategoria);
		model.addAttribute("categorias", categoria);
		
		return "categorias/formCategoria";
	}
	
	
	
	@GetMapping("/guargar")
	public String guargar(Categoria categoria) {
		System.out.println(categoria);
		serviceCategorias.guardar(categoria);
		return "redirect:/categorias/indexPaginate";
		
	}
}
