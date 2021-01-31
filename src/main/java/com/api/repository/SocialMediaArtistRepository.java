package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.domain.model.SocialMediaArtist;

public interface SocialMediaArtistRepository extends JpaRepository<SocialMediaArtist, Long> {

}
