package es.everis.library.entity.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "FILMS")
@DiscriminatorValue(value="FILM")
@PrimaryKeyJoinColumn(name="WORK_ID")
public class Film extends Work implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.REFRESH)
	@JoinTable(
		      name="FILM_DIRECTORS",
		      joinColumns=@JoinColumn(name="WORK_ID"),
		      inverseJoinColumns=@JoinColumn(name="DIRECTOR_ID", referencedColumnName="ARTIST_ID"))
	private List<Artist> directors;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.REFRESH)
	private List<ActorWithRoleFilm> actorWithRoleFilm;
	
	private double duration;
	
	public List<Artist> getDirectors() {
		if(directors == null || directors.isEmpty()) {
			return new ArrayList<Artist>();
		}
		return directors;
	}
	public void setDirectors(List<Artist> directors) {
		this.directors = directors;
	}
	public List<ActorWithRoleFilm> getActors() {
		if(actorWithRoleFilm == null || actorWithRoleFilm.isEmpty()) {
			return new ArrayList<ActorWithRoleFilm>();
		}
		return actorWithRoleFilm;
	}
	public void setActors(List<ActorWithRoleFilm> actors) {
		this.actorWithRoleFilm = actors;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}

}
