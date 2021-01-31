package com.api.domain.builder;

import java.util.Date;

import com.api.domain.model.Album;
import com.api.domain.model.Artist;
import com.api.domain.model.Music;
import com.api.domain.model.MusicGenre;

public class MusicBuilder {
	private Music music;
	
	private MusicBuilder() {
		this.music = new Music();
	}
	
	public static MusicBuilder builder() {
		return new MusicBuilder();
	}
	
	public MusicBuilder id(Long id) {
		this.music.setId(id);
		return this;
	}
	
	public MusicBuilder name(String name) {
		this.music.setName(name);
		return this;
	}
	
	public MusicBuilder musicTime(Date musicTime) {
		this.music.setMusicTime(musicTime);
		return this;
	}
	
	public MusicBuilder release(Date release) {
		this.music.setRelease(release);
		return this;
	}
	
	public MusicBuilder album(Album album) {
		this.music.setAlbum(album);
		return this;
	}
	
	public MusicBuilder artist(Artist artist) {
		this.music.setArtist(artist);
		return this;
	}
	
	public MusicBuilder musicGenre(MusicGenre musicGenre) {
		this.music.setMusicGenre(musicGenre);
		return this;
	}
	
	public MusicBuilder votes(Long votes) {
		this.music.setVotes(votes);
		return this;
	}
	
	public MusicBuilder image(byte[] image) {
		this.music.setImage(image);
		return this;
	}
	
	public Music get() {
		return this.music;
	}
}
