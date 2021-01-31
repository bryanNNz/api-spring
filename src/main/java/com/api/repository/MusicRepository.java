package com.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.api.domain.model.Music;

public interface MusicRepository extends JpaRepository<Music, Long>{

	Page<Music> findByNameContaining(String name, Pageable paging);
	
	Page<Music> findByMusicGenre(@Param("id") Long id, Pageable paging);
	
	Page<Music> findByArtist(@Param("id") Long id, Pageable paging);
	
	Page<Music> findByAlbum(@Param("id") Long id, Pageable paging);
}
