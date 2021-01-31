package com.api.domain.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_ALB")
public class Album implements Serializable {
	private static final long serialVersionUID = 5965860993893844419L;
	
	@Id
	@SequenceGenerator(name = "SQ_ALB_ID", sequenceName = "SQ_ALB_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ALB_ID")
	@Column(name = "ALB_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "ART_ID", referencedColumnName = "ART_ID")
	private Artist artist;
	
	@Column(name = "ALB_DT_LANCAMENTO")
	@Temporal(TemporalType.DATE)
	private Date release;
	
	@Column(name = "ALB_NOME")
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Music> musics;
	
	@Lob
	@Column(name = "ALB_FOTO")
	@Type(type = "org.hibernate.type.BinaryType")
	private byte[] image;

	public Album() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public Date getRelease() {
		return release;
	}

	public void setRelease(Date release) {
		this.release = release;
	}

	public List<Music> getMusics() {
		return musics;
	}

	public void setMusics(List<Music> musics) {
		this.musics = musics;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Arrays.hashCode(image);
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
		Album other = (Album) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (!Arrays.equals(image, other.image))
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
