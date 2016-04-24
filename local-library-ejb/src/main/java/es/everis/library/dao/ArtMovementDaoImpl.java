package es.everis.library.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import es.everis.library.entity.business.ArtMovement;

@Stateless
//@JPADAO
public class ArtMovementDaoImpl extends BaseDaoImpl<ArtMovement>
				implements ArtMovementDao {

	public ArtMovementDaoImpl() {
		super(ArtMovement.class);
	}
	
	@Override
	public List<ArtMovement> findAllOrderByCentury(Integer century) {
		Query query = getEntityManager().createQuery("Select d From " + 
				entityName + " d Order By d.century");
		
		@SuppressWarnings("unchecked")
		List<ArtMovement> artMovements = query.getResultList();
		return artMovements;
	}

}
