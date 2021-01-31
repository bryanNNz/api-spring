package com.api.domain.builder;

import com.api.domain.model.SocialMedia;

public class SocialMediaBuilder {
	private SocialMedia socialMedia;
	
	private SocialMediaBuilder() {
		this.socialMedia = new SocialMedia();
	}
	
	public static SocialMediaBuilder builder() {
		return new SocialMediaBuilder();
	}
	
	public SocialMediaBuilder id(Long id) {
		this.socialMedia.setId(id);
		return this;
	}
	
	public SocialMediaBuilder description(String description) {
		this.socialMedia.setDescription(description);
		return this;
	}
	
	public SocialMedia get() {
		return this.socialMedia;
	}
}
