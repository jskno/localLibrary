package es.everis.library.ejb;

import java.util.List;

import es.everis.library.entity.business.ArtMovement;

public interface ArtMovementService extends BaseService<ArtMovement> {
	
	public List<ArtMovement> findAllOrderByCentury(Integer	century);

}
