package com.aluracursos.libros.service;

import java.util.Optional;

import com.aluracursos.libros.record.LibroDTO;

public interface IConsumoAPIService {

	String obtenerLenguaje(String codigo);

	Optional<LibroDTO> obtenerLibro(String titulo);



}
