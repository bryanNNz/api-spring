package com.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.api.domain.exception.ApiException;
import com.api.domain.exception.EntityNotFoundException;
import com.api.domain.model.Artista;
import com.api.repository.ArtistaRepository;

@Service
public class ArtistaService {
	
	@Autowired
	private ArtistaRepository artistaRepository;
	
	public Artista create(Artista artista) {
		return this.persist(artista);
	}
	
	public Artista update(Artista artista) {
		if(ObjectUtils.isEmpty(artista) || artista.getId() <= 0) {
			throw new ApiException("ENTIDADE NAO EXISTE");
		}
		
		return this.persist(artista);
	}
	
	public void delete(Long id) {
		boolean artistaExists =  this.artistaRepository.existsById(id);
		
		if(!artistaExists) {
			throw new EntityNotFoundException(String.format("ARTISTA ID: [%s] NAO ENCONTRADO", id));
		}
		
		this.artistaRepository.deleteById(id);
	}
		
	public Artista findById(Long id) {
		return this.artistaRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(String.format("ARTISTA ID: [%s] NAO ENCONTRADO", id)));
	}
	
	public Artista persist(Artista artista) {
		return this.artistaRepository.save(artista);
	}
}
