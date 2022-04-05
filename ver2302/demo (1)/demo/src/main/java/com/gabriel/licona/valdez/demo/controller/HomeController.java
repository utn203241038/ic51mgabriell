package com.gabriel.licona.valdez.demo.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gabriel.licona.valdez.demo.model.Vacante;
import com.gabriel.licona.valdez.demo.servicee.IntVacantes;
@Controller
public class HomeController {
	
	
	@Autowired
	private IntVacantes serviceVacantes;
	
	@GetMapping("/")
	public String home(Model model) {
		List<Vacante> vacantes = new LinkedList<Vacante>();
		vacantes = serviceVacantes.obtenerTodos();
		for(Vacante v : vacantes) {
			System.out.println(v);
			
		}
		model.addAttribute("vacantes", vacantes);
		return "home";
	}
	
	@GetMapping("/contactos")
	public String contacto() {
		return "acerca";
	}
	 @GetMapping("/mostrar")
	 public String mostrar(@RequestParam("id") Integer id , Model model) {
		 Vacante v= new Vacante();
		 v = serviceVacantes.buscarPorId(id);
		 model.addAttribute("vacante", v);
		 return "vacantes/detalles";
	 }
	 
	
	
}
