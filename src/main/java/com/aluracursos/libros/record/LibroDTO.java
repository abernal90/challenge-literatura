package com.aluracursos.libros.record;

import java.util.List;

public record LibroDTO(String titulo, Integer numeroDescargas, List<AutorDTO> autores, List<LenguajeDTO> lenguajes) {

}
