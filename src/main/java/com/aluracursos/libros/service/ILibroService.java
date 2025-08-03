package com.aluracursos.libros.service;

import java.util.List;

import com.aluracursos.libros.record.AutorDTO;
import com.aluracursos.libros.record.LibroDTO;

public interface ILibroService {

	List<LibroDTO> buscarPorTitulo(String titulo);

	void guardarLibro(LibroDTO libroDTO);

	List<LibroDTO> obtenerLibros();

	List<LibroDTO> buscarPorLenguaje(String lenguaje);

	List<AutorDTO> obtenerAutores();

	List<AutorDTO> obtenerAutoresPorAnio(Integer anio);

}
