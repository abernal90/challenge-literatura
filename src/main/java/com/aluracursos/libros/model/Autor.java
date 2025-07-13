package com.aluracursos.libros.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa la tabla de autor
 */
@Getter
@Setter
@Entity
@Table(name = "autor")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 250)
    private String nombre;
    
    private Integer anioInicio;
    
    private Integer anioFin;
    
    @ManyToMany(mappedBy = "autores")
    private Set<Libro> libros;

	public Autor(String nombre, Integer anioInicio, Integer anioFin) {
		super();
		this.nombre = nombre;
		this.anioInicio = anioInicio;
		this.anioFin = anioFin;
	}
    
}