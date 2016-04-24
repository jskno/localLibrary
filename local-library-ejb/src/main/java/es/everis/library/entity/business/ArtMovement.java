package es.everis.library.entity.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import es.everis.library.entity.commom.GenericEntityBean;

@Entity
@Table(name="ART_MOVEMENTS")
public class ArtMovement extends GenericEntityBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ART_MOVEMENT_ID")
	private Integer artMovementId;
	
	@Column(name="ART_MOVEMENT_NAME")
	private String artMovementName;
	
	@Column(name="CENTURY")
	private Integer century;

	@OneToMany(mappedBy="artMovement")
	private List<Work> works;
	
//	private List<Artist> pioneers
	
	public Integer getArtMovementId() {
		return artMovementId;
	}
	public void setArtMovementId(Integer artMovementId) {
		this.artMovementId = artMovementId;
	}
	public String getArtMovementName() {
		return artMovementName;
	}
	public void setArtMovementName(String artMovementName) {
		this.artMovementName = artMovementName;
	}
	public Integer getCentury() {
		return century;
	}
	public void setCentury(Integer century) {
		this.century = century;
	}
	public List<Work> getWorks() {
		if(works == null || works.isEmpty()) {
			return new ArrayList<Work>();
		}
		return works;
	}
	public void setWorks(List<Work> works) {
		this.works = works;
	}
	
	@Override
	public String toString() {
		return "ArtMovement [artMovementId=" + artMovementId
				+ ", artMovementName=" + artMovementName + ", century="
				+ century + ", works=" + works + "]";
	}

}
