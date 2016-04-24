package es.everis.library.ejb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import es.everis.library.dao.ArtMovementDao;
import es.everis.library.entity.business.ArtMovement;

@Stateless
public class ArtMovementServiceBean extends BaseServiceBean<ArtMovement>
				implements ArtMovementService {
	
	@EJB
//	@Inject @JPADAO 
	private ArtMovementDao artMovementDao;
	
	@PostConstruct
	public void setDaoToSuperClass() {
		super.setBaseDao(artMovementDao);
	}
	
	public void setArtMovementDao(ArtMovementDao artMovementDao) {
		this.artMovementDao = artMovementDao;
	}
	
	@Override
	public List<ArtMovement> findAllOrderByCentury(Integer century) {
		return artMovementDao.findAllOrderByCentury(century);
	}

}
