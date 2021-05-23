package com.salesianostriana.dam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Alejandro
 *
 *Lo primero que haremos sera aniadir las anotaciones @Entity, @Data,
 *@NoArgsContructor, @AllArgsContructor.
 *Con el @Data anaidiremos los getters and setters, equals y el hashcode y el toString.
 *Con el @NoArgsContructor se genera un constructor sin parametros.
 *Con el @AllArgsContructor se genera un constructor con un parametro para cada campo.
 *Con el @Entity definimos el tipo de la clase
 */
@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Cartelera {
	
	/**
	 * Cuando hayamos aniadido los campos de la clase, aniadiremos la anotacion @Id,@GeneratedValue.
	 * Con la anotacion @Id aniadimos a la clave primaria al primer campo.
	 * Con la anotacion @GeneratedValue autoincrementamos el valor del campo.
	 */
	
	@Id
	@GeneratedValue
	private long id;
	
	private String nombre;
	
	private String imagen;
	
	private double precio;
	
	/**
	 * A continuacion anaidimos la anotacion @ManyToOne, haciendo una relacion de mucha a uno.
	 */
	
	
	@ManyToOne
	
	private Genero genero;
	
	

}
