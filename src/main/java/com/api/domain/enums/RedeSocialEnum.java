package com.api.domain.enums;

public enum RedeSocialEnum {
	FACEBOOK("FACEBOOK"),
	INSTAGRAM("INSTAGRAM"),
	WIKIPEDIA("WIKIPEDIA"),
	TWITTER("TWITTER");
	
	private String nome;
	
	RedeSocialEnum(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
}
