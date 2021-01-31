package com.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.domain.model.Musica;

public interface MusicaRepository extends JpaRepository<Musica, Long>{

	Page<Musica> findByNomeContaining(String name, Pageable paging);
	
	@Query("SELECT m FROM Musica m WHERE m.generoMusical.id = :id")
	Page<Musica> findByGenre(@Param("id") Long id, Pageable paging);
	
	@Query("SELECT m FROM Musica m WHERE m.artista.id = :id")
	Page<Musica> findByArtist(@Param("id") Long id, Pageable paging);
	
	@Query("SELECT m FROM Musica m WHERE m.album.id = :id")
	Page<Musica> findByAlbum(@Param("id") Long id, Pageable paging);
}
