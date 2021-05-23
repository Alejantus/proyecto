package com.salesianostriana.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.model.Cartelera;
import com.salesianostriana.dam.servicies.CarteleraService;
import com.salesianostriana.dam.servicies.GeneroService;

/**
 * 
 * @author Alejandro
 *
 *Lo primero que haremos sera aniadir las anotaciones @Controller y @RequestMapping 
 *al principio de la clase.
 *Con la etiqueta @Controller defino la clase y con la etiqueta
 *@RequestMapping obtenemos a traves de una url algo.
 *
 */
@Controller
@RequestMapping("/admin/cartelera")
public class CarteleraController {
	
	/**
	 * Cuando hayamos creado los campos necesarios usaremos las etiquetas @Autowired,
	 * @GetMapping y @PostMapping.
	 * Con la etiqueta @Autowired realizas una inyeccion.
	 * Con la etiqueta @GetMapping obtenemos algo a traves de una url pero
	 * con la etiqueta @PostMapping obtenemos una url para mas despues.
	 */
	
	@Autowired
	private CarteleraService carteleraService;
	
	@Autowired
	private GeneroService generoService;
	
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("carteleras", carteleraService.findAll());
		
		return "index";
	}
	
	@GetMapping("/nuevo")
	public String nuevaProducto(Model model) {
		
		model.addAttribute("cartelera", new Cartelera());
		//En el formulario de un nuevo producto, debemos elegir con un select una categoría de la lista de categorías
		//que hay, por lo que debemos pasar al modelo dicha lista de categorías.
		//En este caso le hemos llamado categorias y la sacamos con findAll de CategoriaService
		
		model.addAttribute("genero", generoService.findAll());
		return "admin/form-cartelera";
	}

	@PostMapping("/nuevo/submit")
	public String submitNuevoProducto(Cartelera producto, Model model) {

		carteleraService.save(producto);
		return "redirect:/admin/cartelera/";

	}
	
	@GetMapping("/editar/{id}")
	public String editarProducto(@PathVariable("id") Long id, Model model) {

		Cartelera cartelera = carteleraService.findById(id);

		if (cartelera != null) {
			model.addAttribute("cartelera", cartelera);
			model.addAttribute("genero", generoService.findAll());
			return "admin/form-cartelera";
		} else {
			return "redirect:/admin/cartelera/";
		}

	}
	
	
	@GetMapping("/borrar/{id}")
	public String borrarProducto(@PathVariable("id") Long id, Model model) {

		Cartelera cartelera = carteleraService.findById(id);

		if (cartelera != null) {
			carteleraService.delete(cartelera);
		}

		return "redirect:/admin/cartelera/";

	}

}
