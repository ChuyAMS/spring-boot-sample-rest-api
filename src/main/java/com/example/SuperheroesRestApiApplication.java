package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableJpaAuditing
public class SuperheroesRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuperheroesRestApiApplication.class, args);
	}

}

@RestController
class HolaServicio {
	@GetMapping(value = "/persona/{id}")
	public Persona getMethodName(@PathVariable String id) {
		Persona persona = new Persona();
		persona.setNombre("Juan");
		persona.setApellido("Perez");
		return persona;
	}

}

class Persona {
	private String nombre;

	private String apellido;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}