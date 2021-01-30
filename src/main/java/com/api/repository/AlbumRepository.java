package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.domain.business.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {

}
