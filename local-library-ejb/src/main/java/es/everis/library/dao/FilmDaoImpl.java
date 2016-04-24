package es.everis.library.dao;

import javax.ejb.Stateless;

import es.everis.library.entity.business.Film;

@Stateless
public class FilmDaoImpl extends WorkDaoImpl<Film> implements FilmDao {

	public FilmDaoImpl() {
		super(Film.class);
	}
	

}
