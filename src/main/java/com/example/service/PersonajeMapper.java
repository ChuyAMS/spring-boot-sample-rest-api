package com.example.service;

import org.springframework.stereotype.Component;

import com.example.domain.Franquicia;
import com.example.domain.Personaje;
import com.example.web.dto.PersonajeDTO;

@Component
public class PersonajeMapper implements ObjectMapper<Personaje, PersonajeDTO> {

	private FranquiciaService franquiciaService;

	public PersonajeMapper(FranquiciaService franquiciaService) {
		super();
		this.franquiciaService = franquiciaService;
	}

	@Override
	public PersonajeDTO mapToDto(Personaje personaje) {
		return null;
	}

	@Override
	public Personaje mapToEntity(PersonajeDTO dto) {
		Franquicia franquicia = franquiciaService.findOne(dto.getFranquiciaId());

		Personaje personaje = new Personaje();
		personaje.setNombre(dto.getNombre());
		personaje.setFranquicia(franquicia);
		personaje.setNivelPoder(dto.getNivelPoder());
		personaje.setRaza(dto.getRaza());
		personaje.setDescripcion(dto.getDescripcion());

		return personaje;
	}

}
