package com.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.api.domain.exception.ApiException;
import com.api.domain.exception.EntityNotFoundException;
import com.api.domain.model.Musica;
import com.api.repository.MusicaRepository;

@Service
public class MusicaService {
	
	@Autowired
	private MusicaRepository musicaRepository;
	
	public Musica create(Musica musica) {
		return this.persist(musica);
	}
	
	public Musica update(Musica musica) {
		if(ObjectUtils.isEmpty(musica)) {
			throw new ApiException("ENTIDADE NAO EXISTE");
		}
		
		return this.persist(musica);
	}
	
	public void delete(Long id) {
		boolean musicaExists =  this.musicaRepository.existsById(id);
		
		if(!musicaExists) {
			throw new EntityNotFoundException(String.format("MUSICA ID: [%s] NAO ENCONTRADO", id));
		}
		
		this.musicaRepository.deleteById(id);
	}
		
	public Musica findById(Long id) {
		return this.musicaRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(String.format("MUSICA ID: [%s] NAO ENCONTRADO", id)));
	}
	
	public List<Musica> findLikeName(String name, Integer page, Integer size) {
		Pageable paging = PageRequest.of(page, size);
		
		Page<Musica> objs = this.musicaRepository.findByNomeContaining(name, paging);
		
		if(!objs.hasContent())
			new EntityNotFoundException("ENTIDADES NAO ENCONTRADAS");
		
		return objs.getContent();	
	}
	
	public List<Musica> findByGenre(Long id, Integer page, Integer size) {
		Pageable paging = PageRequest.of(page, size);
		
		Page<Musica> objs = this.musicaRepository.findByGenre(id, paging);
		
		if(!objs.hasContent())
			new EntityNotFoundException("ENTIDADES NAO ENCONTRADAS");
		
		return objs.getContent();
	}
	
	public List<Musica> findByArtist(Long id, Integer page, Integer size) {
		Pageable paging = PageRequest.of(page, size);
		
		Page<Musica> objs = this.musicaRepository.findByArtist(id, paging);
		
		if(!objs.hasContent())
			new EntityNotFoundException("ENTIDADES NAO ENCONTRADAS");
		
		return objs.getContent();
	}
	
	public List<Musica> findByAlbum(Long id, Integer page, Integer size) {
		Pageable paging = PageRequest.of(page, size);
		
		Page<Musica> objs = this.musicaRepository.findByAlbum(id, paging);
		
		if(!objs.hasContent())
			new EntityNotFoundException("ENTIDADES NAO ENCONTRADAS");
		
		return objs.getContent();
	}
	
	public List<Musica> findAll(Integer page, Integer size, String sort) {
		Pageable paging = PageRequest.of(page, size, Sort.by(sort));
		
		Page<Musica> objs = this.musicaRepository.findAll(paging);
		
		if(!objs.hasContent())
			new EntityNotFoundException("ENTIDADES NAO ENCONTRADAS");
		
		return objs.getContent();	
	}
	
	public Musica persist(Musica musica) {
		return this.musicaRepository.save(musica);
	}
	
}
