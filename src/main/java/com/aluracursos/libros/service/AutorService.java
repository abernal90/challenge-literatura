package com.aluracursos.libros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aluracursos.libros.model.Autor;
import com.aluracursos.libros.record.AutorDTO;
import com.aluracursos.libros.repository.AutorRepository;

@Service
public class AutorService implements IAutorService{
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Override
	public List<AutorDTO> obtenerAutores() {
		return autorRepository.findDistinctNombre()
				.stream().map(this::convertirEntityToDTO).toList();
	}
	
	@Override
	public List<AutorDTO> obtenerAutoresPorAnio(Integer anio) {
		return autorRepository.findAutorByAnio(anio)
				.stream().map(this::convertirEntityToDTO).toList();
	}
	
	
	private AutorDTO convertirEntityToDTO(Autor entity) {
		return new AutorDTO(entity.getNombre(), entity.getAnioInicio(), entity.getAnioFin());
	}

}
