package com.api.domain.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "TB_MSC")
public class Music implements Serializable {
	private static final long serialVersionUID = -8528475585291568947L;
	
	@Id
	@SequenceGenerator(name = "SQ_MSC_ID", sequenceName = "SQ_MSC_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_MSC_ID")
	@Column(name = "MSC_ID")
	private Long id;
	
	@Column(name = "MSC_NOME")
	private String name;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "MSC_DURACAO")
	private Date musicTime;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "MSC_LANCAMENTO")
	private Date release;
	
	@ManyToOne
	@JoinColumn(name = "ALB_ID", referencedColumnName = "ALB_ID")
	private Album album;
	
	@ManyToOne
	@JoinColumn(name = "ART_ID", referencedColumnName = "ART_ID")
	private Artist artist;
	
	@ManyToOne
	@JoinColumn(name = "GNR_ID", referencedColumnName = "GNR_ID")
	private MusicGenre musicGenre;
	
	@Column(name = "MSC_VOTOS")
	private Long votes;
	
	@Lob
	@Column(name = "MSC_FOTO")
	@Type(type = "org.hibernate.type.BinaryType")
	private byte[] image;

	public Music() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getMusicTime() {
		return musicTime;
	}

	public void setMusicTime(Date musicTime) {
		this.musicTime = musicTime;
	}

	public Date getRelease() {
		return release;
	}

	public void setRelease(Date release) {
		this.release = release;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public MusicGenre getMusicGenre() {
		return musicGenre;
	}

	public void setMusicGenre(MusicGenre musicGenre) {
		this.musicGenre = musicGenre;
	}

	public Long getVotes() {
		return votes;
	}

	public void setVotes(Long votes) {
		this.votes = votes;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((album == null) ? 0 : album.hashCode());
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Arrays.hashCode(image);
		result = prime * result + ((musicGenre == null) ? 0 : musicGenre.hashCode());
		result = prime * result + ((musicTime == null) ? 0 : musicTime.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((release == null) ? 0 : release.hashCode());
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
		Music other = (Music) obj;
		if (album == null) {
			if (other.album != null)
				return false;
		} else if (!album.equals(other.album))
			return false;
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
		if (!Arrays.equals(image, other.image))
			return false;
		if (musicGenre == null) {
			if (other.musicGenre != null)
				return false;
		} else if (!musicGenre.equals(other.musicGenre))
			return false;
		if (musicTime == null) {
			if (other.musicTime != null)
				return false;
		} else if (!musicTime.equals(other.musicTime))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (release == null) {
			if (other.release != null)
				return false;
		} else if (!release.equals(other.release))
			return false;
		return true;
	}
	
}
