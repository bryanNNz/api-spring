package com.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.api.domain.model.Musica;
import com.api.service.MusicaService;

@Controller
@RequestMapping
public class MusicaResource {

	@Autowired
	private MusicaService musicaService;
	
	@RequestMapping(
			method = RequestMethod.POST,
			value = "/musica",
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Musica> save(@RequestBody Musica musica) {
		Musica obj = this.musicaService.create(musica);
		return ResponseEntity.ok().body(obj); 
	}
	
	@RequestMapping(
			method = RequestMethod.PUT,
			value = "/musica",
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Musica> update(@RequestBody Musica musica) {
		Musica obj = this.musicaService.update(musica);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(
			method = RequestMethod.DELETE,
			value = "/musica/{id}")
	public ResponseEntity<Musica> delete(@PathVariable Long id) {
		this.musicaService.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
