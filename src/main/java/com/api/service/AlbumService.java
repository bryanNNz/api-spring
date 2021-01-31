package com.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.api.domain.exception.EntityNotFoundException;
import com.api.domain.model.Album;
import com.api.repository.AlbumRepository;

@Service
public class AlbumService {
	
	@Autowired
	private AlbumRepository albumRepository;
	
	public Album create(Album album) {
		return this.persist(album);
	}
	
	public Album update(Album album) {
		if(ObjectUtils.isEmpty(album))
			throw new IllegalArgumentException("INVALID ARGUMENT");
		
		return this.persist(album);
	}
	
	public void deleteByArtist(Long id) {
		List<Album> objs = this.albumRepository.findByArtistId(id);
		
		if(ObjectUtils.isEmpty(objs))
			throw new EntityNotFoundException(String.format("ALBUMS NOT FOUND FOR ARTIST ID: [%s]", id));
		
		this.albumRepository.deleteAll(objs);
	}
		
	public Album findById(Long id) {
		return this.albumRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(String.format("ALBUM ID: [%s] NOT FOUND", id)));
	}
	
	public List<Album> findByArtist(Long id, Integer page, Integer size) {
		Pageable paging = PageRequest.of(page, size);
		
		Page<Album> objs = this.albumRepository.findByArtistId(id, paging);
		
		if(!objs.hasContent())
			throw new EntityNotFoundException(String.format("ALBUMS NOT FOUND FOR ARTIST ID [%s]", id));
		
		return objs.getContent();
	}
	
	public Album persist(Album album) {
		return this.albumRepository.save(album);
	}
	
}
