package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.domain.model.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

}
