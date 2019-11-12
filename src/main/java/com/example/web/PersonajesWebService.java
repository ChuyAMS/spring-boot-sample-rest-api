package com.example.web;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.domain.Franquicia;
import com.example.domain.Personaje;
import com.example.service.FranquiciaService;
import com.example.service.ObjectMapper;
import com.example.service.PersonajesService;
import com.example.web.dto.PersonajeDTO;

@RestController
@RequestMapping("personajes")
public class PersonajesWebService {

	@Autowired
	private PersonajesService personajesService;

	@Autowired
	private ObjectMapper<Personaje, PersonajeDTO> personajeMapper;

	@GetMapping(value = "/{id}")
	public Personaje getById(@PathVariable Integer id) {
		return personajesService.findOne(id);
	}

	@GetMapping(value = "")
	public List<Personaje> getAll() {
		return personajesService.getAll();
	}

	@PostMapping(value = "")
	public ResponseEntity<Personaje> create(@Valid @RequestBody PersonajeDTO personajeDTO) {

		Personaje personajeCreado = personajesService.save(personajeMapper.mapToEntity(personajeDTO));

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(personajeCreado.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Personaje> update(@PathVariable Integer id, @Valid @RequestBody Personaje personaje) {

		getById(id);
		personajesService.save(personaje);

		return ResponseEntity.accepted().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Personaje> delete(@PathVariable Integer id) {
		this.personajesService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping(value = "/{id}/franquicia")
	public Franquicia getFranquicia(@PathVariable Integer id) {
		return personajesService.findOne(id).getFranquicia();
	}

}
