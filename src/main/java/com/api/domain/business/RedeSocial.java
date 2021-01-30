package com.api.domain.business;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.api.domain.enums.RedeSocialEnum;

@Entity
@Table(name = "TB_RDS")
public class RedeSocial implements Serializable {
	private static final long serialVersionUID = -3712656693574902461L;
	
	@Id
	@SequenceGenerator(name = "SQ_RDS_ID", sequenceName = "SQ_RDS_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_RDS_ID")
	@Column(name = "RDS_ID")
	private Long id;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "RDS_REDE")
	private RedeSocialEnum redeSocial;

	public RedeSocial() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RedeSocialEnum getRedeSocial() {
		return redeSocial;
	}

	public void setRedeSocial(RedeSocialEnum redeSocial) {
		this.redeSocial = redeSocial;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		RedeSocial other = (RedeSocial) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (redeSocial != other.redeSocial)
			return false;
		return true;
	}
	
}
