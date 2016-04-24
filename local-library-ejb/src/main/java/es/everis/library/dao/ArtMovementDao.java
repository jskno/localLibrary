package es.everis.library.dao;

import java.util.List;

import es.everis.library.entity.business.ArtMovement;

public interface ArtMovementDao extends BaseDao<ArtMovement> {
	
	public List<ArtMovement> findAllOrderByCentury(Integer	century);

}
