package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.domain.Personaje;

public interface PersonajesDAO extends JpaRepository<Personaje, Integer> {

}
