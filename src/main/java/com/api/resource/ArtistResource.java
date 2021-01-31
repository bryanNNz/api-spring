package com.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.api.domain.model.Artist;
import com.api.service.ArtistService;

@Controller
@RequestMapping
public class ArtistResource {
	
	@Autowired
	private ArtistService artistService;
	
	@RequestMapping(
			method = RequestMethod.POST,
			value = "/artist",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Artist> save(@RequestBody Artist artist) {
		Artist obj = this.artistService.create(artist);
		return ResponseEntity.ok().body(obj); 
	}
	
	@RequestMapping(
			method = RequestMethod.PUT,
			value = "/artist",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Artist> update(@RequestBody Artist artist) {
		Artist obj = this.artistService.update(artist);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(
			method = RequestMethod.DELETE,
			value = "/artist/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		this.artistService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(
			method = RequestMethod.GET,
			value = "/artists",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Artist>> getAll(
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable paging) {
		List<Artist> objs = this.artistService.findAll(paging);
		
		return ResponseEntity.ok().body(objs);
	}
}
