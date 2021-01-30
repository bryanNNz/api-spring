package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.domain.model.Artista;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

}
