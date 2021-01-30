package com.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.api.domain.model.Artista;
import com.api.service.ArtistaService;

@Controller
@RequestMapping
public class ArtistaResource {
	
	@Autowired
	private ArtistaService artistaService;
	
	@RequestMapping(
			method = RequestMethod.POST,
			value = "/artista",
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Artista> save(@RequestBody Artista artista) {
		Artista obj = this.artistaService.create(artista);
		return ResponseEntity.ok().body(obj); 
	}
	
	@RequestMapping(
			method = RequestMethod.PUT,
			value = "/artista",
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Artista> update(@RequestBody Artista artista) {
		Artista obj = this.artistaService.update(artista);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(
			method = RequestMethod.DELETE,
			value = "/artista/{id}")
	public ResponseEntity<Artista> delete(@PathVariable Long id) {
		this.artistaService.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
