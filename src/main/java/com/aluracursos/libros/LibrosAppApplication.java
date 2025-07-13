package com.aluracursos.libros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aluracursos.libros.principal.Principal;

@SpringBootApplication
public class LibrosAppApplication implements CommandLineRunner {

	@Autowired
	private Principal principal;
	
	public static void main(String[] args) {
		SpringApplication.run(LibrosAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		principal.iniciarMenu();
	}

}
