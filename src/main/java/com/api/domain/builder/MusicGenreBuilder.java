package com.api.domain.builder;

import com.api.domain.model.MusicGenre;

public class MusicGenreBuilder {
	private MusicGenre musicGenre;
	
	private MusicGenreBuilder() {
		this.musicGenre = new MusicGenre();
	}
	
	public static MusicGenreBuilder builder() {
		return new MusicGenreBuilder();
	}
	
	public MusicGenreBuilder id(Long id) {
		this.musicGenre.setId(id);
		return this;
	}
	
	public MusicGenreBuilder description(String description) {
		this.musicGenre.setDescription(description);
		return this;
	}
	
	public MusicGenre get() {
		return this.musicGenre;
	}
}
