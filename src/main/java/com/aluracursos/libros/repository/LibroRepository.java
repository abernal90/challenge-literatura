package com.aluracursos.libros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aluracursos.libros.model.Libro;

public interface LibroRepository extends JpaRepository<Libro,Integer> {
	
	List<Libro> findByTitulo(String titulo);
	
	@Query("SELECT l FROM Libro l JOIN FETCH l.lenguajes le WHERE le.nombre LIKE %:lenguaje%")
	List<Libro> findByLenguaje(String lenguaje);

}
