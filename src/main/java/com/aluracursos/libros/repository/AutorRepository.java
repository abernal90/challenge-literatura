package com.aluracursos.libros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aluracursos.libros.model.Autor;

public interface AutorRepository extends JpaRepository<Autor,Integer> {
	
	@Query("SELECT DISTINCT new com.aluracursos.libros.model.Autor(a.nombre, a.anioInicio, a.anioFin) FROM Autor a")
	List<Autor> findDistinctNombre();
	
	@Query("SELECT a FROM Autor a WHERE a.anioInicio <= :anio AND a.anioFin >= :anio")
	List<Autor> findAutorByAnio(Integer anio);

}
