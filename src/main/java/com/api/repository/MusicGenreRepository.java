package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.domain.model.MusicGenre;

public interface MusicGenreRepository extends JpaRepository<MusicGenre, Long>{

}
