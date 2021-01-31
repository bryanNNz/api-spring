package com.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.api.domain.model.Artista;
import com.api.service.ArtistaService;

@Controller
@RequestMapping
public class ArtistaResource {
	
	@Autowired
	private ArtistaService artistService;
	
	@RequestMapping(
			method = RequestMethod.POST,
			value = "/artist",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Artista> save(@RequestBody Artista artista) {
		Artista obj = this.artistService.create(artista);
		return ResponseEntity.ok().body(obj); 
	}
	
	@RequestMapping(
			method = RequestMethod.PUT,
			value = "/artist",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Artista> update(@RequestBody Artista artista) {
		Artista obj = this.artistService.update(artista);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(
			method = RequestMethod.DELETE,
			value = "/artist/{id}")
	public void delete(@PathVariable Long id) {
		this.artistService.delete(id);
	}
	
	@RequestMapping(
			method = RequestMethod.GET,
			value = "/artists",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Artista>> getAll(
			@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "10") Integer size,
			@RequestParam(defaultValue = "name") String sort) {
		
		List<Artista> objs = this.artistService.findAll(page, size, sort);
		
		return ResponseEntity.ok().body(objs);
	}
}
