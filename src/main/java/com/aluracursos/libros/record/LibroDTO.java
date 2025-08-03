package com.aluracursos.libros.record;

public record LibroDTO(String titulo, Integer numeroDescargas, String autor,
		Integer anioInicio, Integer anioFin, String codigoLenguaje, String lenguaje) {

}
