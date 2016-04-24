package es.library.model;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;

import es.everis.library.entity.business.Film;

@Model
public class FilmData extends WorkData {
	
	private double duration;

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	public Film fromData() {
		Film film = new Film();
		super.fromData(film);
		film.setDuration(getDuration());
		return film;
	}
	
	public FilmData toData(Film film) {
		FilmData filmData = new FilmData();
		super.toData(film);
		filmData.setDuration(film.getDuration());
		return filmData;
	}
	
	public List<FilmData> toData(List<Film> films) {
		List<FilmData> filmData = new ArrayList<FilmData>();
		for(Film film : films) {
			filmData.add(toData(film));
		}
		return filmData;
	} 
}
