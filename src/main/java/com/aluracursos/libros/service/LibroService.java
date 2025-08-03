package com.aluracursos.libros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aluracursos.libros.model.Libro;
import com.aluracursos.libros.record.AutorDTO;
import com.aluracursos.libros.record.LibroDTO;
import com.aluracursos.libros.repository.LibroRepository;

@Service
public class LibroService implements ILibroService {

	@Autowired
	private LibroRepository libroRepository;
	
	
	@Override
	@Transactional
	public List<LibroDTO> obtenerLibros() {
		List<Libro> resultQuery = libroRepository.findAll();
		return resultQuery.stream().map(this::convertirEntityToDTO).toList();
	}

	@Override
	@Transactional
	public List<LibroDTO> buscarPorTitulo(String titulo) {
		List<Libro> resultQuery = libroRepository.findByTitulo(titulo);
		return resultQuery.stream().map(this::convertirEntityToDTO).toList();
	}
	
	@Override
	@Transactional
	public List<LibroDTO> buscarPorLenguaje(String lenguaje) {
		List<Libro> resultQuery = libroRepository.findByLenguaje(lenguaje);
		return resultQuery.stream().map(this::convertirEntityToDTO).toList();
	}
	
	@Override
	@Transactional
	public void guardarLibro(LibroDTO libroDTO) {
		var libro = convertirDTOToEntity(libroDTO);
		libroRepository.save(libro);
	}
	
	@Override
	@Transactional
	public List<AutorDTO> obtenerAutores(){
		return libroRepository.findAllAutores();
	}
	
	@Override
	@Transactional
	public List<AutorDTO> obtenerAutoresPorAnio(Integer anio){
		return libroRepository.findByAnio(anio);
	}
	
	
	/**
	 * @param entity
	 * @return
	 */
	private LibroDTO convertirEntityToDTO(Libro entity) {
		return new LibroDTO(entity.getTitulo(), entity.getNumeroDescargas(), entity.getAutor(),
				entity.getAnioInicio(),entity.getAnioFin(), entity.getCodigoLenguaje(), 
				entity.getLenguaje());
	}
	
	/**
	 * @param libroDTO
	 * @return
	 */
	private Libro convertirDTOToEntity(LibroDTO libroDTO) {
		return Libro.builder()
				.titulo(libroDTO.titulo())
				.numeroDescargas(libroDTO.numeroDescargas())
				.autor(libroDTO.autor())
				.anioInicio(libroDTO.anioInicio())
				.anioFin(libroDTO.anioFin())
				.codigoLenguaje(libroDTO.codigoLenguaje())
				.lenguaje(libroDTO.lenguaje())
				.build();
	}

}
