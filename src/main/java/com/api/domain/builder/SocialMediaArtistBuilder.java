package com.api.domain.builder;

import com.api.domain.model.Artist;
import com.api.domain.model.SocialMedia;
import com.api.domain.model.SocialMediaArtist;

public class SocialMediaArtistBuilder {
	private SocialMediaArtist socialMediaArtist;
	
	private SocialMediaArtistBuilder() {
		this.socialMediaArtist = new SocialMediaArtist();
	}
	
	public static SocialMediaArtistBuilder builder() {
		return new SocialMediaArtistBuilder();
	}
	
	public SocialMediaArtistBuilder socialMedia(SocialMedia socialMedia) {
		this.socialMediaArtist.setSocialMedia(socialMedia);
		return this;
	}
	
	public SocialMediaArtistBuilder artist(Artist artist) {
		this.socialMediaArtist.setArtist(artist);
		return this;
	}
	
	public SocialMediaArtistBuilder link(String link) {
		this.socialMediaArtist.setLink(link);
		return this;
	}
	
	public SocialMediaArtist get() {
		return this.socialMediaArtist;
	}
}
