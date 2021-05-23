package com.salesianostriana.dam.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.model.Genero;
import com.salesianostriana.dam.repositories.GeneroRepository;

/**
 * 
 * @author Alejandro
 *
 *Lo primero que haremos sera aniadir la etiqueta @Service, para definir el tipo de la clase.
 */
@Service
public class GeneroService {
	
	/**
	 *Cuando hayamos escrito todos los campos de la clase lo que haremos sera
	 *utilizar la anotacion @Autowired para realizar una inyeccion.
	 *Con el metodo findAll lo que queremos es que devuelva toda la informacion del repositorio.
	 *Con el metodo finDestacadas es obtener un tipo booleano.
	 *Con el metodo save su funcion es guardar la informacion.
	 *Con el metodo findById lo que queremos es buscar por su id.
	 *Con el metodo delete queremos eliminar a traves de su identidficador. 
	 */
	
	@Autowired
	private GeneroRepository generoRepository;
	
	public List<Genero> findAll() {
		return generoRepository.findAll();
	}	
	
	public List<Genero> findDestacadas() {
		return generoRepository.findDestacadas();
	}
	
	public Genero save(Genero genero) {
		return generoRepository.save(genero);
	}
	
	public Genero findById(Long id) {
		return generoRepository.findById(id).orElse(null);
	}
	
	public Genero delete(Genero genero) {
		Genero result = findById(genero.getId());
		generoRepository.delete(result);
		return result;
	}

}
