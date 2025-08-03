package com.aluracursos.libros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aluracursos.libros.model.Libro;
import com.aluracursos.libros.record.AutorDTO;

public interface LibroRepository extends JpaRepository<Libro,Integer> {
	
	List<Libro> findByTitulo(String titulo);
	
	@Query("SELECT l FROM Libro l WHERE unaccent(l.lenguaje) = :lenguaje ")
	List<Libro> findByLenguaje(String lenguaje);
	
	@Query("SELECT DISTINCT new com.aluracursos.libros.record.AutorDTO(l.autor, l.anioInicio, l.anioFin)  l FROM Libro l")
	List<AutorDTO> findAllAutores();
	
	@Query("SELECT DISTINCT new com.aluracursos.libros.record.AutorDTO(l.autor, l.anioInicio, l.anioFin)  l FROM Libro l"
			+ " WHERE l.anioInicio <= :anio AND l.anioFin >= :anio")
	List<AutorDTO> findByAnio(Integer anio);

}
