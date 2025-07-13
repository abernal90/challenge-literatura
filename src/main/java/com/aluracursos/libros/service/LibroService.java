package com.aluracursos.libros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aluracursos.libros.model.Autor;
import com.aluracursos.libros.model.Lenguaje;
import com.aluracursos.libros.model.Libro;
import com.aluracursos.libros.record.AutorDTO;
import com.aluracursos.libros.record.LenguajeDTO;
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
	
	
	/**
	 * @param entity
	 * @return
	 */
	private LibroDTO convertirEntityToDTO(Libro entity) {
		return new LibroDTO(entity.getTitulo(), entity.getNumeroDescargas(),
			entity.getAutores().stream().map(autor ->{
				return new AutorDTO(autor.getNombre(), autor.getAnioInicio(), autor.getAnioFin());
			}).toList(),
			entity.getLenguajes().stream().map(lenguaje ->{
				return new LenguajeDTO(lenguaje.getCodigo(), lenguaje.getNombre());
			}).toList());
	}
	
	/**
	 * @param libroDTO
	 * @return
	 */
	private Libro convertirDTOToEntity(LibroDTO libroDTO) {
		var libro = Libro.builder()
				.titulo(libroDTO.titulo())
				.numeroDescargas(libroDTO.numeroDescargas())
				.build();
		List<Autor> autores = libroDTO.autores()
				.stream().map(autorDTO->{
					return Autor.builder()
						.nombre(autorDTO.nombre())
						.anioInicio(autorDTO.anioInicio())
						.anioFin(autorDTO.anioFin())
						.build();
			}).toList();
			libro.getAutores().addAll(autores);
			
		List<Lenguaje> lenguajes = libroDTO.lenguajes()
			.stream().map(lenguajeDTO->{
				return Lenguaje.builder()
					.codigo(lenguajeDTO.codigo())
					.nombre(lenguajeDTO.pais())
					.build();
			}).toList();
		libro.getLenguajes().addAll(lenguajes);
		return libro;
	}

}
