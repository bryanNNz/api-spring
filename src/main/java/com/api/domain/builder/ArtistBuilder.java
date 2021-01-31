package com.api.domain.builder;

import java.util.List;

import com.api.domain.model.Album;
import com.api.domain.model.Artist;
import com.api.domain.model.SocialMediaArtist;

public class ArtistBuilder {
	private Artist artist;
	
	private ArtistBuilder() {
		this.artist = new Artist();
	}
	
	public static ArtistBuilder builder() {
		return new ArtistBuilder();
	}
	
	public ArtistBuilder id(Long id) {
		this.artist.setId(id);
		return this;
	}
	
	public ArtistBuilder name(String name) {
		this.artist.setName(name);
		return this;
	}
	
	public ArtistBuilder bio(String bio) {
		this.artist.setBio(bio);
		return this;
	}
	
	public ArtistBuilder image(byte[] image) {
		this.artist.setImage(image);
		return this;
	}
	
	public ArtistBuilder albums(List<Album> albums) {
		this.artist.setAlbums(albums);
		return this;
	}
	
	public ArtistBuilder socialMediaArtist(List<SocialMediaArtist> socialMediaArtist) {
		this.artist.setSocialMedias(socialMediaArtist);
		return this;
	}
	
	public Artist get() {
		return this.artist;
	}
	
}
