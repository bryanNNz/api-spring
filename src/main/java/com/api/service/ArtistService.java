package com.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.api.domain.exception.EntityNotFoundException;
import com.api.domain.model.Artist;
import com.api.repository.ArtistRepository;

@Service
public class ArtistService {
	
	@Autowired
	private ArtistRepository artistRepository;
	
	public Artist create(Artist artist) {
		return this.persist(artist);
	}
	
	public Artist update(Artist artist) {
		if(ObjectUtils.isEmpty(artist))
			throw new IllegalArgumentException("INVALID ARGUMENT");
		
		return this.persist(artist);
	}
	
	public void delete(Long id) {
		boolean artistExists =  this.artistRepository.existsById(id);
		
		if(!artistExists)
			throw new EntityNotFoundException(String.format("ARTIST ID: [%s] NOT FOUND", id));
		
		this.artistRepository.deleteById(id);
	}
		
	public Artist findById(Long id) {
		return this.artistRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(String.format("ARTIST ID: [%s] NOT FOUND", id)));
	}
	
	public List<Artist> findAll(Integer page, Integer size, String sort) {
		Pageable paging = PageRequest.of(page, size, Sort.by(sort));
		
		Page<Artist> objs = this.artistRepository.findAll(paging);
		
		if(!objs.hasContent())
			new EntityNotFoundException("ALBUMS NOT FOUND");
		
		return objs.getContent();	
	}
	
	public Artist persist(Artist artist) {
		return this.artistRepository.save(artist);
	}
}
