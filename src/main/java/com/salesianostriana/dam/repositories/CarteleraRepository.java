package com.salesianostriana.dam.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.salesianostriana.dam.model.Genero;
import com.salesianostriana.dam.model.Cartelera;

public interface CarteleraRepository extends JpaRepository<Cartelera, Long> {
	
	/**
	 * 
	 * @param genero
	 * @return
	 * 
	 * Aqui se van a ejecutar las consultas de la base datos.
	 */

	public List<Cartelera> findByGenero(Genero genero);
	
	@Query("select c.id from Cartelera c")
	public List<Long> obtenerIds();
	
	@Query("select c from Cartelera c where c.genero.id = ?1")
	public List<Cartelera> findByCategoriaId(Long categoriaId);
	
	@Query("select count(c) from Cartelera c where c.genero = ?1")
	public int findNumProductosByCategoria(Genero genero);

}
