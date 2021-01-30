package com.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.api.domain.model.Album;
import com.api.service.AlbumService;

@Controller
@RequestMapping
public class AlbumResource {

	@Autowired
	private AlbumService albumService;
	
	@RequestMapping(
			method = RequestMethod.POST,
			value = "/album",
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Album> save(@RequestBody Album album) {
		Album obj = this.albumService.create(album);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(
			method = RequestMethod.PUT,
			value = "/album",
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Album> update(@RequestBody Album album) {
		Album obj = this.albumService.update(album);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(
			method = RequestMethod.DELETE,
			value = "/album/{id}")
	public ResponseEntity<Album> delete(@PathVariable Long id) {
		this.albumService.delete(id);
		return ResponseEntity.ok().build();
	}

}
