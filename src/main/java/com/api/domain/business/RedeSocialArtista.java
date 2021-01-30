package com.api.domain.business;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_RDS_ART")
public class RedeSocialArtista implements Serializable {
	private static final long serialVersionUID = 7979004524053213892L;
	
	@Id
	@SequenceGenerator(name = "SQ_RDS_ART_ID", sequenceName = "SQ_RDS_ART_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_RDS_ART_ID")
	@Column(name = "RDS_ART_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "RDS_ID", referencedColumnName = "RDS_ID")
	private RedeSocial redeSocial;
	
	@ManyToOne
	@JoinColumn(name = "ART_ID", referencedColumnName = "ART_ID")
	private Artista artista;
	
	@Column(name = "RDS_ART_LINK")
	private String link;

	public RedeSocialArtista() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RedeSocial getRedeSocial() {
		return redeSocial;
	}

	public void setRedeSocial(RedeSocial redeSocial) {
		this.redeSocial = redeSocial;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artista == null) ? 0 : artista.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + ((redeSocial == null) ? 0 : redeSocial.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RedeSocialArtista other = (RedeSocialArtista) obj;
		if (artista == null) {
			if (other.artista != null)
				return false;
		} else if (!artista.equals(other.artista))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (redeSocial == null) {
			if (other.redeSocial != null)
				return false;
		} else if (!redeSocial.equals(other.redeSocial))
			return false;
		return true;
	}
	
}
