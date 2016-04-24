package es.library.data.to.view;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import es.everis.library.ejb.ArtMovementService;
import es.everis.library.entity.business.ArtMovement;

@Named("artMovementList")
@ApplicationScoped
public class ArtMovementList implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private ArtMovementService artMovementService;
	
	private Map<Integer, String> artMovements;
	private Integer choosenOne;
	
	public ArtMovementList() {
		artMovements = new HashMap<Integer, String>();
	}

	@PostConstruct
	public void initArtMovementList() {
		for(ArtMovement artMovement : artMovementService.getAll()) {
			artMovements.put(artMovement.getArtMovementId(), artMovement.getArtMovementName());
		}
	}
	
	public Map<Integer, String> getArtMovements() {
		initArtMovementList();
		return artMovements;
	}

	public void setArtMovements(Map<Integer, String> artMovements) {
		this.artMovements = artMovements;
	}

	public Integer getChoosenOne() {
		return choosenOne;
	}

	public void setChoosenOne(Integer choosenOne) {
		this.choosenOne = choosenOne;
	}

}
