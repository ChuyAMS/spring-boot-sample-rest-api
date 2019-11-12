package com.example.service;

import java.util.List;

import com.example.domain.Franquicia;

public interface FranquiciaService {

	public List<Franquicia> getAll();

	public Franquicia findOne(Integer id);

	public Franquicia save(Franquicia franquicia);

	void delete(Integer id);
}
