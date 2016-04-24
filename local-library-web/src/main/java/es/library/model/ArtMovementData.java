package es.library.model;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;

import es.everis.library.entity.business.ArtMovement;

@Model
public class ArtMovementData {
	
	private Integer id;
	private String name;
	private Integer century;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCentury() {
		return century;
	}
	public void setCentury(Integer century) {
		this.century = century;
	}
	
	public static ArtMovement fromData(ArtMovementData artMovementData) {
		if (artMovementData == null) {
			return null;
		}
		ArtMovement artMovement = new ArtMovement();
		artMovement.setArtMovementId(artMovementData.getId());
		artMovement.setArtMovementName(artMovementData.getName());
		artMovement.setCentury(artMovementData.getCentury());
		return artMovement;
	}
	
	public static ArtMovementData toData(ArtMovement artMovement) {
		if (artMovement == null) {
			return null;
		}
		ArtMovementData artMovementData = new ArtMovementData();
		artMovementData.setId(artMovement.getArtMovementId());
		artMovementData.setName(artMovement.getArtMovementName());
		artMovementData.setCentury(artMovement.getCentury());
		return artMovementData;
	}
	
	public static List<ArtMovementData> toData(List<ArtMovement> artMovements) {
		if(artMovements == null || artMovements.isEmpty()) {
			return null;
		}
		List<ArtMovementData> artMovementsData = new ArrayList<ArtMovementData>();
		for(ArtMovement artMovement : artMovements) {
			artMovementsData.add(toData(artMovement));
		}
		return artMovementsData;
	}

}
