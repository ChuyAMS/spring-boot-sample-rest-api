package com.example.service;

public interface ObjectMapper<E, D> {

	public D mapToDto(E personaje);

	public E mapToEntity(D dto);

}
