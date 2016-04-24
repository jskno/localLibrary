package es.everis.library.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import es.everis.library.dao.FilmDao;
import es.everis.library.entity.business.Film;

@Stateless
public class FilmServiceBean extends WorkServiceBean<Film>
				implements FilmService {
	
	@EJB
//	@Inject @JPADAO 
	private FilmDao filmDao;
	
	@PostConstruct
	public void setDaoToSuperClass() {
		super.setWorkDao(filmDao);
	}
	
	public void setBookDao(FilmDao filmDao) {
		this.filmDao = filmDao;
	}

}
