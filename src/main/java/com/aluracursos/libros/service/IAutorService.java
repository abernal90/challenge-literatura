package com.aluracursos.libros.service;

import java.util.List;

import com.aluracursos.libros.record.AutorDTO;

public interface IAutorService {

	List<AutorDTO> obtenerAutores();

	List<AutorDTO> obtenerAutoresPorAnio(Integer anio);

}
