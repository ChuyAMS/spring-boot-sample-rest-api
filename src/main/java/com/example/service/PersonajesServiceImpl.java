package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.dao.PersonajesDAO;
import com.example.domain.Personaje;
import com.example.exception.DataNotFoundException;

@Service
public class PersonajesServiceImpl implements PersonajesService {

	private PersonajesDAO personajesDAO;

	public PersonajesServiceImpl(PersonajesDAO personajesDAO) {
		super();
		this.personajesDAO = personajesDAO;
	}

	@Override
	public List<Personaje> getAll() {
		return personajesDAO.findAll();
	}

	@Override
	public Personaje findOne(Integer id) {
		Optional<Personaje> personaje = personajesDAO.findById(id);
		if (!personaje.isPresent()) {
			throw new DataNotFoundException("No se puede encontrar el personaje con el id " + id);
		}
		return personaje.get();
	}

	@Override
	public Personaje save(Personaje franquicia) {
		return personajesDAO.save(franquicia);
	}

	@Override
	public void delete(Integer id) {
		personajesDAO.deleteById(id);
	}

}
