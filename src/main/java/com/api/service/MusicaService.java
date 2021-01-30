package com.api.service;

import org.springframework.beans.factory.annotation.Autowired;
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
		if(ObjectUtils.isEmpty(musica) || musica.getId() <= 0) {
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
	
	public Musica persist(Musica musica) {
		return this.musicaRepository.save(musica);
	}
	
}
