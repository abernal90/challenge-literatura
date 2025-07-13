package com.aluracursos.libros.constant;


/**
 * Clase de constantes
 */
public final class Constantes {
	
    public static final String MENSAJE_MENU_INICIAL = """
            
            **********************************************
            Elija la opción a través de su número:
            
            1) Buscar libro por título
            2) Listar libros registrados
            3) Listar autores registrados
            4) Listar autores en un determinado año
            5) Listar libros por idioma
            0) Salir
             **********************************************
            """;
	
	// URL API que devuelve el lenguaje a base del código de lenguaje iso 639-1
	public static final String URL_API_CODIGO_LENGUAJE = "https://magicloops.dev/api/loop/dd266a3d-ae0e-4aa8-a859-c2f0cd66f0ac/run";
	
	// Request body del API que devuelve el lenguaje
	public static final String BODY_API_CODIGO_LENGUAJE = "{\"lang_code\": \"%s\"}";
	
	
	//URL API que busca un libro y devulve la información de el libro
	public static final String URL_API_LIBROS = "https://gutendex.com/books/?page=1&search=";
	

}
