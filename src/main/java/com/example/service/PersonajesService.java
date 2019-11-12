package com.example.service;

import java.util.List;

import com.example.domain.Personaje;

public interface PersonajesService {
	public List<Personaje> getAll();

	public Personaje findOne(Integer id);

	public Personaje save(Personaje franquicia);

	void delete(Integer id);
}
