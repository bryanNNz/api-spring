package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.domain.model.SocialMedia;

public interface SocialMediaRepository extends JpaRepository<SocialMedia, Long> {

}
