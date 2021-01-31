package com.api.domain.type;

public enum SocialMediaType {
	FACEBOOK("FACEBOOK"),
	INSTAGRAM("INSTAGRAM"),
	WIKIPEDIA("WIKIPEDIA"),
	TWITTER("TWITTER");
	
	private String name;
	
	SocialMediaType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
