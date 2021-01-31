package com.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.api.domain.model.Music;

public interface MusicRepository extends JpaRepository<Music, Long>{

	Page<Music> findByNameContaining(String name, Pageable paging);
	
	Page<Music> findByMusicGenreId(Long id, Pageable paging);
	
	Page<Music> findByArtistId(Long id, Pageable paging);
	
	Page<Music> findByAlbumId(Long id, Pageable paging);
}
