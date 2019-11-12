package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.FranquiciaDAO;
import com.example.domain.Franquicia;
import com.example.exception.DataNotFoundException;

@Service
@Transactional
public class FranquiciaServiceImpl implements FranquiciaService {

	private FranquiciaDAO franquiciaDAO;

	public FranquiciaServiceImpl(FranquiciaDAO franquiciaDAO) {
		super();
		this.franquiciaDAO = franquiciaDAO;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Franquicia> getAll() {
		return franquiciaDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Franquicia findOne(Integer id) {
		Optional<Franquicia> franquicia = franquiciaDAO.findById(id);
		if (!franquicia.isPresent()) {
			throw new DataNotFoundException("No se puede encontrar la franquicia con el id " + id);
		}
		return franquicia.get();
	}

	@Override
	public Franquicia save(Franquicia franquicia) {
		return franquiciaDAO.save(franquicia);
	}

	@Override
	public void delete(Integer id) {
		franquiciaDAO.deleteById(id);
	}

}
