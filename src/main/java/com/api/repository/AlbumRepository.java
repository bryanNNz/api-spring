package com.api.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.domain.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {

	@Query("SELECT a FROM Album a WHERE a.artista.id = :id")
	Page<Album> findByArtistPageable(@Param("id") Long id, Pageable paging);
	
	@Query("SELECT a FROM Album a WHERE a.artista.id = :id")
	List<Album> findByArtist(@Param("id") Long id);
}
