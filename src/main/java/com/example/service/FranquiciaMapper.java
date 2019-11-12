package com.example.service;

import org.springframework.stereotype.Service;

import com.example.domain.Franquicia;
import com.example.domain.Personaje;
import com.example.web.dto.FranquiciaDTO;
import com.example.web.dto.PersonajeDTO;

@Service
public class FranquiciaMapper implements ObjectMapper<Franquicia, FranquiciaDTO> {

	@Override
	public FranquiciaDTO mapToDto(Franquicia personaje) {
		return null;
	}

	@Override
	public Franquicia mapToEntity(FranquiciaDTO dto) {
		Franquicia franquicia = new Franquicia();
		franquicia.setNombre(dto.getNombre());
		franquicia.setDescripcion(dto.getDescripcion());
		return franquicia;
	}

}
