package com.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.api.domain.exception.EntityNotFoundException;
import com.api.domain.model.Music;
import com.api.repository.MusicRepository;

@Service
public class MusicService {
	
	@Autowired
	private MusicRepository musicRepository;
	
	public Music create(Music music) {
		return this.persist(music);
	}
	
	public Music update(Music music) {
		if(ObjectUtils.isEmpty(music))
			throw new IllegalArgumentException("INVALID ARGUMENT");
		
		return this.persist(music);
	}
	
	public void delete(Long id) {
		boolean musicExists =  this.musicRepository.existsById(id);
		
		if(!musicExists)
			throw new EntityNotFoundException(String.format("MUSIC ID: [%s] NOT FOUND", id));
		
		this.musicRepository.deleteById(id);
	}
		
	public Music findById(Long id) {
		return this.musicRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(String.format("MUSIC ID: [%s] NOT FOUND", id)));
	}
	
	public List<Music> findLikeName(String name, Integer page, Integer size) { //VER
		Pageable paging = PageRequest.of(page, size);
		
		Page<Music> objs = this.musicRepository.findByNameContaining(name, paging);
		
		if(!objs.hasContent())
			new EntityNotFoundException(String.format("MUSICS NOT FOUND FOR NAME [%s]", name));
		
		return objs.getContent();	
	}
	
	public List<Music> findByGenre(Long id, Integer page, Integer size) {
		Pageable paging = PageRequest.of(page, size);
		
		Page<Music> objs = this.musicRepository.findByMusicGenreId(id, paging);
		
		if(!objs.hasContent())
			new EntityNotFoundException(String.format("MUSICS NOT FOUND FOR GENRE ID [%s]", id));
		
		return objs.getContent();
	}
	
	public List<Music> findByArtist(Long id, Integer page, Integer size) {
		Pageable paging = PageRequest.of(page, size);
		
		Page<Music> objs = this.musicRepository.findByArtistId(id, paging);
		
		if(!objs.hasContent())
			new EntityNotFoundException(String.format("MUSICS NOT FOUND FOR ARTIST ID [%s]", id));
		
		return objs.getContent();
	}
	
	public List<Music> findByAlbum(Long id, Integer page, Integer size) {
		Pageable paging = PageRequest.of(page, size);
		
		Page<Music> objs = this.musicRepository.findByAlbumId(id, paging);
		
		if(!objs.hasContent())
			new EntityNotFoundException(String.format("MUSICS NOT FOUND FOR ALBUM ID [%s]", id));
		
		return objs.getContent();
	}
	
	public List<Music> findAll(Pageable paging) {
		Page<Music> objs = this.musicRepository.findAll(paging);
		
		if(!objs.hasContent())
			new EntityNotFoundException("MUSICS NOT FOUND");
		
		return objs.getContent();	
	}
	
	public Music persist(Music music) {
		return this.musicRepository.save(music);
	}
	
}
