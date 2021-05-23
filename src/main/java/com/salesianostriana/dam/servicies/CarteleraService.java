package com.salesianostriana.dam.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.model.Cartelera;
import com.salesianostriana.dam.model.Genero;
import com.salesianostriana.dam.repositories.CarteleraRepository;

/**
 * 
 * @author Alejandro
 *
 * Lo primero que haremos sera aniadir la etiqueta @Service, para definir el tipo de la clase.
 */
@Service
public class CarteleraService {
	
	/**
	 * Cuando hayamos escrito todos los campos de la clase lo que haremos sera
	 *utilizar la anotacion @Autowired para realizar una inyeccion.
	 *Con el metodo findAll lo que queremos es que devuelva toda la informacion del repositorio.
	 *Con el metodo finDestacadas es obtener un tipo booleano.
	 *Con el metodo save su funcion es guardar la informacion.
	 *Con el metodo findById lo que queremos es buscar por su id.
	 *Con el metodo delete queremos eliminar a traves de su identidficador. 
	 */
	@Autowired
	private CarteleraRepository carteleraRepository;
	
	public List<Cartelera> findAll() {
		return carteleraRepository.findAll();
	}
	
	public List<Cartelera> findAllByCategoria(Genero genero) {
		return carteleraRepository.findByGenero(genero);
	}
	
	public List<Cartelera> findAllByCategoria(Long categoriaId) {
		return carteleraRepository.findByCategoriaId(categoriaId);
	}
	
	public Cartelera findById(Long id) {
		return carteleraRepository.findById(id).orElse(null);
	}
	
	public Cartelera save(Cartelera cartelera) {
		return carteleraRepository.save(cartelera);
	}
	
	public Cartelera delete(Cartelera cartelera) {
		Cartelera resultado = findById(cartelera.getId());
		carteleraRepository.delete(resultado);
		return resultado;
	}
	
	public int numeroProductosCategoria(Genero genero) {
		return carteleraRepository.findNumProductosByCategoria(genero);
	}

}
