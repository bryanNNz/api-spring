package com.api.domain.business;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
	private Artista artista;
	
	@Column(name = "ALB_DT_LANCAMENTO")
	@Temporal(TemporalType.DATE)
	private Date lancamento;
	
	@OneToMany(mappedBy = "album")
	private List<Musica> musicas;
	
	@Lob
	@Column(name = "ALB_FOTO")
	@Type(type = "org.hibernate.type.BinaryType")
	private byte[] foto;

	public Album() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public Date getLancamento() {
		return lancamento;
	}

	public void setLancamento(Date lancamento) {
		this.lancamento = lancamento;
	}

	public List<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(List<Musica> musicas) {
		this.musicas = musicas;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(foto);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lancamento == null) ? 0 : lancamento.hashCode());
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
		if (!Arrays.equals(foto, other.foto))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lancamento == null) {
			if (other.lancamento != null)
				return false;
		} else if (!lancamento.equals(other.lancamento))
			return false;
		return true;
	}
	
}
