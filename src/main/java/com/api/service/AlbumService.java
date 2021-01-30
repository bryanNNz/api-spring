package com.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.api.domain.exception.ApiException;
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
		if(ObjectUtils.isEmpty(album) || album.getId() <= 0) {
			throw new ApiException("ENTIDADE NAO EXISTE");
		}
		
		return this.persist(album);
	}
	
	public void delete(Long id) {
		boolean albumExists =  this.albumRepository.existsById(id);
		
		if(!albumExists) {
			throw new EntityNotFoundException(String.format("ALBUM ID: [%s] NAO ENCONTRADO", id));
		}
		
		this.albumRepository.deleteById(id);
	}
		
	public Album findById(Long id) {
		return this.albumRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(String.format("ALBUM ID: [%s] NAO ENCONTRADO", id)));
	}
	
	public Album persist(Album album) {
		return this.albumRepository.save(album);
	}
	
}
