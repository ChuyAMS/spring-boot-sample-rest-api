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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.domain.Franquicia;
import com.example.domain.Personaje;
import com.example.service.FranquiciaMapper;
import com.example.service.FranquiciaService;
import com.example.web.dto.FranquiciaDTO;

@RestController
@RequestMapping("franquicias")
public class FranquiciaWebService {

	@Autowired
	private FranquiciaService franquiciaService;
	
	@Autowired
	private FranquiciaMapper franquiciaMapper;

	@GetMapping(value = "/{id}")
	public Franquicia get(@PathVariable Integer id) {
		return franquiciaService.findOne(id);
	}

	@GetMapping(value = "")
	public List<Franquicia> getAll() {
		return franquiciaService.getAll();
	}

	@PostMapping(value = "")
	public ResponseEntity<Franquicia> save(@RequestBody @Valid FranquiciaDTO dto) {

		Franquicia franquiciaCreada = franquiciaService.save(franquiciaMapper.mapToEntity(dto));

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(franquiciaCreada.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Franquicia> putMethodName(@PathVariable Integer id, @RequestBody Franquicia franquicia) {

		get(id);
		franquiciaService.save(franquicia);

		return ResponseEntity.accepted().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Franquicia> deleteMethodName(@PathVariable Integer id) {
		this.franquiciaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{id}/personajes")
	public List<Personaje> getPersonajes(@PathVariable Integer id) {
		return franquiciaService.findOne(id).getPersonajes();
	}

}
