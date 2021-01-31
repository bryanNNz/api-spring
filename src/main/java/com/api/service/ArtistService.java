package com.api.service;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.api.domain.exception.ApiConstraintViolationException;
import com.api.domain.exception.ApiEntityNotFoundException;
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
			throw new ApiEntityNotFoundException(String.format("ARTIST ID: [%s] NOT FOUND", id));
		
		try {
			this.artistRepository.deleteById(id);			
		} catch(Exception e) {
			if(e.getCause() instanceof ConstraintViolationException)
				throw new ApiConstraintViolationException(String.format("ARTIST ID: [%s] CANNOT BE DELETED BECAUSE IT IS BEING REFERENCED IN THE SYSTEM", id));
		}
	}
		
	public Artist findById(Long id) {
		return this.artistRepository.findById(id)
				.orElseThrow(() -> new ApiEntityNotFoundException(String.format("ARTIST ID: [%s] NOT FOUND", id)));
	}
	
	public List<Artist> findAll(Pageable paging) {		
		Page<Artist> objs = this.artistRepository.findAll(paging);
		
		if(!objs.hasContent())
			new ApiEntityNotFoundException("ALBUMS NOT FOUND");
		
		return objs.getContent();	
	}
	
	public Artist persist(Artist artist) {
		return this.artistRepository.save(artist);
	}
}
