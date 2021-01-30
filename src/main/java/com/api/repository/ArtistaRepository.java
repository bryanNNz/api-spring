package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.domain.business.Artista;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

}
