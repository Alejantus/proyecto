package com.salesianostriana.dam.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.model.Genero;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
	
	/**
	 * 
	 * @return
	 * 
	 * Aqui se va a ejecutar la consulta en la base de datos.
	 */

	@Query("select g from Genero g where g.destacada = true")
	public List<Genero> findDestacadas();
}
