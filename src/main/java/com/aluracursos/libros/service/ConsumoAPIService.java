package com.aluracursos.libros.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.aluracursos.libros.constant.Constantes;
import com.aluracursos.libros.record.AutorDTO;
import com.aluracursos.libros.record.LenguajeDTO;
import com.aluracursos.libros.record.LibroDTO;
import com.aluracursos.libros.record.LanguajeDTO;
import com.google.gson.Gson;

import io.micrometer.common.util.StringUtils;

@Service
public class ConsumoAPIService implements IConsumoAPIService {
	
	@Override
	public String obtenerPais(String codigo) {
		// Creación del objeto URL para hacer la solicitud al API
		var direccion = URI.create(Constantes.URL_API_CODIGO_LENGUAJE);
		// Generamos el cuerpo de la solicitud
		var requestBody = String.format(Constantes.BODY_API_CODIGO_LENGUAJE, codigo);
		// Creación de objeto cliente y la solcitud a realizar al API
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder()
                .uri(direccion)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        try {
            // Se realiza la solicitud y obtenemos la respuesta
            var response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            // Convertimos la respuesta a un objeto
            var lenguaje = new Gson().fromJson(response.body(),LanguajeDTO.class);
            // Validamos si la respuesta fue exitosa
            if(StringUtils.isBlank(lenguaje.error())){
                // Si la respuesta del API fue exitosa devolvemos el nombre del país
                return lenguaje.language_name();
            }else{
                // Si la respuesta del API no fue exitosa devolvemos un mensaje
                throw new RuntimeException("Ocurrio un problema al obtener el país");
            }

        } catch (Exception e) {
            throw new RuntimeException("Ocurrio un problema al obtener el país");
        }

	}
	
	@Override
	public Optional<LibroDTO> obtenerLibro(String titulo) {
	
		// Creación del objeto URL para hacer la solicitud al API
		var direccion = URI.create(Constantes.URL_API_LIBROS.concat(titulo));

		// Creación de objeto cliente y la solcitud a realizar al API
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            // Se realiza la solicitud y obtenemos la respuesta
            var response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            // Convertimos la respuesta a un objeto
            
            var jsonObject = new JSONObject(response.body());
            
            var count = jsonObject.getInt("count");
            
            // Validamos si encontro si el API encontro un libro
            if(count > 0){
                // Si la respuesta del API fue exitosa devolvemos el objeto libro
            	var libroDTO = procesarRespuestaAPILibro(jsonObject);
            	return Optional.of(libroDTO);
            }else {
            	// Si no encontro el libro devolvemos objecto vacion
            	return Optional.empty();
            }

        } catch (Exception e) {
            throw new RuntimeException("Ocurrio un problema al obtener la información de el libro");
        }
		

	}
	
	/**
	 * Procesa el json de respuesta para obtener un objeto LibroDTO
	 * @return LibroDTO
	 */
	private LibroDTO procesarRespuestaAPILibro(JSONObject jsonObject) {
		var results = jsonObject.getJSONArray("results");
    	var jsonLibro = results.getJSONObject(0);
    	
    	List<AutorDTO> autoresDTO = new ArrayList<>();
    	var jsonAutores = jsonLibro.getJSONArray("authors");
    	jsonAutores.forEach(objectAutor->{
    		var jsonAutor = JSONObject.class.cast(objectAutor);
    		autoresDTO.add(
    				new AutorDTO(
    				jsonAutor.getString("name"), 
    				jsonAutor.getInt("birth_year"), 
    				jsonAutor.getInt("death_year"))
    		);
    	});
    	
    	List<LenguajeDTO> lenguajesDTO = new ArrayList<>();
     	var jsonLenguajes = jsonLibro.getJSONArray("languages");
     	jsonLenguajes.forEach(objectLenguaje->{
    		var codigo = objectLenguaje.toString();
    		lenguajesDTO.add(
    				new LenguajeDTO(
						codigo, 
						obtenerPais(codigo))
    		);
    	});
    	
    	var libroDTO = new LibroDTO(
    			jsonLibro.getString("title"), 
    			jsonLibro.getInt("download_count"), 
    			autoresDTO, 
    			lenguajesDTO);
    	return libroDTO;
	}
	
	

}
