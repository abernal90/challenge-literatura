package com.aluracursos.libros.principal;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aluracursos.libros.constant.Constantes;
import com.aluracursos.libros.record.AutorDTO;
import com.aluracursos.libros.record.LibroDTO;
import com.aluracursos.libros.service.IConsumoAPIService;
import com.aluracursos.libros.service.ILibroService;

@Component
public class Principal {
	
	@Autowired
	private ILibroService libroService;
	
	@Autowired
	private IConsumoAPIService consumoAPIService;
	
	public void iniciarMenu() {
		
		try (var lectura = new Scanner(System.in)) {
			var opcion = -1;
			
			while (opcion != 0) {
				
				System.out.println(Constantes.MENSAJE_MENU_INICIAL);
				
			    opcion = lectura.nextInt();
			    System.out.println();
	            switch (opcion) {
	                case 1:
	                	System.out.println("Ingresa el título del libro a buscar\n");
	                	var titulo = lectura.next();
	                	System.out.println("\nPor favor espere...\n");
	                	buscarLibroPorTitulo(titulo);
	                    break;
	                case 2:
	                	obtenerLibrosGuardados();
	                    break;
	                case 3:
	                	obtenerAutoreGuardados();
	                    break;
	                case 4:
	                	System.out.println("Ingresa el año del autor a buscar\n");
	                	var anio = lectura.nextInt();
	                	System.out.println();
	                	obtenerAutorePorAnio(anio);
	                    break;
	                case 5:
	                	System.out.println("Ingresa el idioma del libro a buscar\n");
	                	var idioma = lectura.next();
	                	System.out.println();
	                	obtenerLibrosPorIdioma(idioma);
	                    break;
	                case 0:
	                    System.out.println("Cerrando la aplicación...");
	                    break;
	                default:
	                    System.out.println("Opción inválida");
	            }

				
			}
		}
		
		
	}
	
	private void obtenerLibrosPorIdioma(String idioma) {
		var librosDTO = libroService.buscarPorLenguaje(idioma);
		librosDTO.forEach(this::imprimirLibro);
	}
	
	private void obtenerAutorePorAnio(Integer anio) {
		List<AutorDTO> autores = libroService.obtenerAutoresPorAnio(anio);
		autores.forEach(this::imprimirAutor);
	}
	
	private void obtenerAutoreGuardados() {
		List<AutorDTO> autores = libroService.obtenerAutores();
		autores.forEach(this::imprimirAutor);
	}
	
	private void obtenerLibrosGuardados() {
		var librosDTO = libroService.obtenerLibros();
		librosDTO.forEach(this::imprimirLibro);
	}
	
	private void buscarLibroPorTitulo(String titulo) {
		var optionalLibro = consumoAPIService.obtenerLibro(titulo);
		if(optionalLibro.isPresent()) {
			var libroDTO = optionalLibro.get();
			var librosDTO = libroService.buscarPorTitulo(libroDTO.titulo());
			if(librosDTO.isEmpty()) {
				librosDTO = Arrays.asList(libroDTO);
				libroService.guardarLibro(libroDTO);
			}
			librosDTO.forEach(this::imprimirLibro);
			
		}else {
			System.out.println("No se encontro el título del libro");
		}
		
	}
	
	private void imprimirAutor(AutorDTO autor) {
		System.out.println("\n--------------Autor---------------");
		System.out.printf("Nombre: %s\n", autor.autor());
		System.out.printf("Año de nacimiento: %d\n", autor.anioInicio());
		System.out.printf("Año de fallecimiento: %d\n", autor.anioFin());
		System.out.println("----------------------------------");
	}
	
	private void imprimirLibro(LibroDTO libro) {
		System.out.println("\n--------------Libro---------------");
		System.out.printf("Título: %s\n", libro.titulo());
		System.out.printf("Autor: %s\n", libro.autor());
		System.out.printf("Idioma: %s\n", libro.lenguaje() );
		System.out.printf("Número de descargas: %d\n", libro.numeroDescargas());
		System.out.println("----------------------------------");
	}

}
