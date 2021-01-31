package com.api.domain.builder;

import java.util.Date;
import java.util.List;

import com.api.domain.model.Album;
import com.api.domain.model.Artist;
import com.api.domain.model.Music;

public class AlbumBuilder {
	private Album album;
	
	private AlbumBuilder() {
		this.album = new Album();
	}
	
	public static AlbumBuilder builder() {
		return new AlbumBuilder();
	}
	
	public AlbumBuilder id(Long id) {
		this.album.setId(id);
		return this;
	}
	
	public AlbumBuilder name(String name) {
		this.album.setName(name);
		return this;
	}
	
	public AlbumBuilder artist(Artist artist) {
		this.album.setArtist(artist);
		return this;
	}
	
	public AlbumBuilder release(Date release) {
		this.album.setRelease(release);
		return this;
	}
	
	public AlbumBuilder image(byte[] image) {
		this.album.setImage(image);
		return this;
	}
	
	public AlbumBuilder musics(List<Music> musics) {
		this.album.setMusics(musics);
		return this;
	}
	
	public Album get() {
		return this.album;
	}
}
