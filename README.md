# Consulta de Literatura

Aplicación en java que permite la consulta de información relacionada con una librería virtual:

- 🔍 Buscar libro por título
- 📚 Listar libros registrados
- ✍️ Listar autores registrados
- 📅 Listar autores en un determinado año
- 🌐 Listar libros por idioma


## 💻 Tecnologías utilizadas

- [Java Development Kit 21](https://download.oracle.com/java/21/archive/jdk-21.0.7_windows-x64_bin.exe)
- [Spring Boot 3.5.3](https://start.spring.io/)
- [PostgreSQL 17.5](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads)

## 🛠 Herramientas

- [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download)
- [Git](https://git-scm.com/downloads)

## 📂 Estructura del proyecto

```
challenge-literatura/
com.aluracursos.libros
├── LibrosAppApplication.java      # Clase principal para ejecutar la app
├── constant
│   └── Constantes.java            # Constantes utilizadas en la aplicación
├── model
│   └── Libro.java                 # Entidad del libro
├── principal
│   └── Principal.java             # Clase para manejar la interfaz de usuario por consola
├── record
│   ├── AutorDTO.java              # DTO para autores
│   ├── LanguajeDTO.java           # DTO para lenguajes
│   └── LibroDTO.java              # DTO para libros
├── repository
│   └── LibroRepository.java       # Repositorio para acceso a datos
└── service
    ├── ConsumoAPIService.java     # Implementación de consumo de API
    ├── IConsumoAPIService.java    # Interfaz de consumo de API
    ├── ILibroService.java         # Interfaz del servicio de libros
    └── LibroService.java          # Implementación del servicio de libros
	
src/main/resources
├── application.properties         # Configuración de la aplicación Spring
└── export.sql                     # Script SQL para estructura de base de datos

pom.xml                            # Archivo de configuración de Maven 
README.md                          # Archivo de documentación del proyecto
.gitignore                         # Reglas para ignorar archivos en Git

```

## 📥 Clonar el proyecto

```bash
git clone https://github.com/abernal90/challenge-literatura.git
```

## ▶️ Instrucciones para ejecutar en IntelliJ IDEA

1. Abrir IntelliJ IDEA.
2. Seleccionar **File > Open** y elegir la carpeta del proyecto clonado.
3. Esperar a que se descarguen las dependencias de Maven o Gradle.
4. Asegúrate de que la base de datos PostgreSQL esté activa y configurada correctamente.
5. Ejecutar la clase `LibrosAppApplication.java` como una aplicación Java.
6. Interactuar con la consola según las opciones mostradas.

## 🧪 Uso de la aplicación

Al iniciar la aplicación, verás el siguiente menú en consola:

```
**********************************************
Elija la opción a través de su número:

1) Buscar libro por título
2) Listar libros registrados
3) Listar autores registrados
4) Listar autores en un determinado año
5) Listar libros por idioma
0) Salir
**********************************************
```

### 🧾 Ejemplo de búsqueda por título

```
1

Ingresa el título del libro a buscar

moby

Por favor espere...

--------------Libro---------------
Título: Moby Dick; Or, The Whale
Autor: Melville, Herman
Idioma: inglés
Número de descargas: 115502
----------------------------------
```

## 👤 Autor

Desarrollado por [@abernal90](https://github.com/abernal90) y [Alura Latatan](https://app.aluracursos.com/)
