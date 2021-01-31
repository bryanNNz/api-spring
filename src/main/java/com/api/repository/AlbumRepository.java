package com.api.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.api.domain.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {

	Page<Album> findByArtistId(Long id, Pageable paging);
	
	List<Album> findByArtistId(Long id);
}
