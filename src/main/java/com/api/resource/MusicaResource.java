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

import com.api.domain.model.Musica;
import com.api.service.MusicaService;

@Controller
@RequestMapping
public class MusicaResource {

	@Autowired
	private MusicaService musicService;
	
	@RequestMapping(
			method = RequestMethod.POST,
			value = "/music",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Musica> save(@RequestBody Musica musica) {
		Musica obj = this.musicService.create(musica);
		
		return ResponseEntity.ok().body(obj); 
	}
	
	@RequestMapping(
			method = RequestMethod.PUT,
			value = "/music",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Musica> update(@RequestBody Musica musica) {
		Musica obj = this.musicService.update(musica);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(
			method = RequestMethod.DELETE,
			value = "/music/{id}")
	public void delete(@PathVariable Long id) {
		this.musicService.delete(id);
	}
	
	@RequestMapping(
			method = RequestMethod.GET,
			value = "/musics",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Musica>> getLikeName(
			@RequestParam(name = "name") String name,
			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "10") Integer size) {
		List<Musica> objs = this.musicService.findLikeName(name, page, size);
		
		return ResponseEntity.ok().body(objs);
	}
	
	@RequestMapping(
			method = RequestMethod.GET,
			value = "/musics/genre/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Musica>> getByGenre(
			@PathVariable Long id,
			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "10") Integer size) {
		List<Musica> objs = this.musicService.findByGenre(id, page, size);
		
		return ResponseEntity.ok().body(objs);
	}
	
	@RequestMapping(
			method = RequestMethod.GET,
			value = "/musics/artist/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Musica>> getByArtist(
			@PathVariable Long id,
			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "10") Integer size) {
		List<Musica> objs = this.musicService.findByArtist(id, page, size);
		
		return ResponseEntity.ok().body(objs);
	}
	
	@RequestMapping(
			method = RequestMethod.GET,
			value = "/musics/album/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Musica>> getMusicsByAlbum(
			@PathVariable Long id,
			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "10") Integer size) {
		List<Musica> objs = this.musicService.findByAlbum(id, page, size);
		
		return ResponseEntity.ok().body(objs);
	}
	
	@RequestMapping(
			method = RequestMethod.GET,
			value = "/musics",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Musica>> getMusicsOrderByVotes(
			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "10") Integer size,
			@RequestParam(defaultValue = "votes") String sort) {
		List<Musica> objs = this.musicService.findAll(page, size, sort);
		
		return ResponseEntity.ok().body(objs);
	}
	
}
