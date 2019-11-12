package com.example.web.dto;

import javax.validation.constraints.NotBlank;

public class FranquiciaDTO {
	private Integer id;

	@NotBlank(message = "El campo es obligatorio")
	private String nombre;

	private String descripcion;

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

}
