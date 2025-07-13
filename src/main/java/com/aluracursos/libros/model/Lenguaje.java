package com.aluracursos.libros.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa la tabla de lenguaje
 */

@Entity
@Table(name = "lenguaje")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lenguaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 3)
    private String codigo;

    @Column(length = 250)
    private String nombre;

    @ManyToMany(mappedBy = "lenguajes")
    private Set<Libro> libros;

}