package com.salesianostriana.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.model.Genero;
import com.salesianostriana.dam.servicies.CarteleraService;
import com.salesianostriana.dam.servicies.GeneroService;

/**
 * 
 * @author Alejandro
 *Lo primero que haremos sera aniadir las anotaciones @Controller y @RequestMapping 
 *al principio de la clase.
 *Con la etiqueta @Controller defino la clase y con la etiqueta
 *@RequestMapping obtenemos a traves de una url algo.
 */
@Controller
@RequestMapping("/admin/genero")
public class GeneroController {
	
	/**
	 * Cuando hayamos creado los campos necesarios usaremos las etiquetas @Autowired,
	 * @GetMapping y @PostMapping.
	 * Con la etiqueta @Autowired realizas una inyeccion.
	 * Con la etiqueta @GetMapping obtenemos algo a traves de una url pero
	 * con la etiqueta @PostMapping obtenemos una url para mas despues.
	 */
	
	@Autowired
	private GeneroService generoService;
	
	@Autowired
	private CarteleraService carteleraService;
	
	 @GetMapping("/")
	 public String index(Model model) {
		 
		 
		 return "index";
	 }
	 
	 @GetMapping("/nuevo")
	 public String nuevaGenero(Model model) {
		 model.addAttribute("genero", new Genero());
		 return "admin/form-genero";
	 }
	 
	 @GetMapping("/nuevo/submit")
	 public String submitNuevoGenero(@ModelAttribute("genero") Genero genero, Model model) {
		 generoService.save(genero);
		 
		 return "redirect:/admin/genero";
	 }	 
	 
	 @GetMapping("/editar/{id}")
	 public String editarGenero(@PathVariable("id") Long id, Model model) {
		
		 Genero genero = generoService.findById(id);
		 
		 if(genero != null) {
			 model.addAttribute("genero", genero);
			 return "admin/form-genero";
		 }else {
			 return "redirect:/admin/genero/";
		 }
		 
	 }
	 
	 @GetMapping("/borrar/{id}")
	 public String borrarGenero(@PathVariable("id") Long id, Model model) {
		 Genero genero = generoService.findById(id);
		 
		 if (genero != null) {
			 
			 if (carteleraService.numeroProductosCategoria(genero) == 0) {
				generoService.delete(genero);
			} else {
				return "redirect:/admin/genero/?error=true";
			}
			
		}
		return "redirect:/admin/genero/";
	 }

}
