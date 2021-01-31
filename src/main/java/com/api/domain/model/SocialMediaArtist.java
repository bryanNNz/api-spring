package com.api.domain.model;

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
public class SocialMediaArtist implements Serializable {
	private static final long serialVersionUID = 7979004524053213892L;
	
	@Id
	@SequenceGenerator(name = "SQ_RDS_ART_ID", sequenceName = "SQ_RDS_ART_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_RDS_ART_ID")
	@Column(name = "RDS_ART_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "RDS_ID", referencedColumnName = "RDS_ID")
	private SocialMedia socialMedia;
	
	@ManyToOne
	@JoinColumn(name = "ART_ID", referencedColumnName = "ART_ID")
	private Artist artist;
	
	@Column(name = "RDS_ART_LINK")
	private String link;

	public SocialMediaArtist() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SocialMedia getSocialMedia() {
		return socialMedia;
	}

	public void setSocialMedia(SocialMedia socialMedia) {
		this.socialMedia = socialMedia;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
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
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + ((socialMedia == null) ? 0 : socialMedia.hashCode());
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
		SocialMediaArtist other = (SocialMediaArtist) obj;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
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
		if (socialMedia == null) {
			if (other.socialMedia != null)
				return false;
		} else if (!socialMedia.equals(other.socialMedia))
			return false;
		return true;
	}

}
