package com.example.web.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class PersonajeDTO {
	/** The id */
	private Integer id;

	@NotBlank
	private String nombre;

	private String descripcion;
	
	@NotBlank
	private String raza;

	@Min(value = 0)
	private int nivelPoder;

	@Min(value = 1)
	private int franquiciaId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public int getNivelPoder() {
		return nivelPoder;
	}

	public void setNivelPoder(int nivelPoder) {
		this.nivelPoder = nivelPoder;
	}

	public int getFranquiciaId() {
		return franquiciaId;
	}

	public void setFranquiciaId(int franquiciaId) {
		this.franquiciaId = franquiciaId;
	}

}
