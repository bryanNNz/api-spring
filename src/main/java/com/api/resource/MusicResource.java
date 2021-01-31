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

import com.api.domain.model.Music;
import com.api.service.MusicService;

@Controller
@RequestMapping
public class MusicResource {

	@Autowired
	private MusicService musicService;
	
	@RequestMapping(
			method = RequestMethod.POST,
			value = "/music",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Music> save(@RequestBody Music music) {
		Music obj = this.musicService.create(music);
		
		return ResponseEntity.ok().body(obj); 
	}
	
	@RequestMapping(
			method = RequestMethod.PUT,
			value = "/music",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Music> update(@RequestBody Music music) {
		Music obj = this.musicService.update(music);
		
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
	public ResponseEntity<List<Music>> getLikeName(
			@RequestParam(name = "name") String name,
			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "10") Integer size) {
		List<Music> objs = this.musicService.findLikeName(name, page, size);
		
		return ResponseEntity.ok().body(objs);
	}
	
	@RequestMapping(
			method = RequestMethod.GET,
			value = "/musics/genre/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Music>> getByGenre(
			@PathVariable Long id,
			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "10") Integer size) {
		List<Music> objs = this.musicService.findByGenre(id, page, size);
		
		return ResponseEntity.ok().body(objs);
	}
	
	@RequestMapping(
			method = RequestMethod.GET,
			value = "/musics/artist/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Music>> getByArtist(
			@PathVariable Long id,
			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "10") Integer size) {
		List<Music> objs = this.musicService.findByArtist(id, page, size);
		
		return ResponseEntity.ok().body(objs);
	}
	
	@RequestMapping(
			method = RequestMethod.GET,
			value = "/musics/album/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Music>> getMusicsByAlbum(
			@PathVariable Long id,
			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "10") Integer size) {
		List<Music> objs = this.musicService.findByAlbum(id, page, size);
		
		return ResponseEntity.ok().body(objs);
	}
	
	@RequestMapping(
			method = RequestMethod.GET,
			value = "/musics/ranking",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Music>> getMusicsOrderByVotes(
			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "10") Integer size,
			@RequestParam(defaultValue = "votes") String sort) {
		List<Music> objs = this.musicService.findAll(page, size, sort);
		
		return ResponseEntity.ok().body(objs);
	}
	
}
