package es.everis.library.entity.examples;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="MOVIES")
public class Movie implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private MovieId movieId;
	
	private String director;
	@ElementCollection(fetch = FetchType.EAGER)
	@Column(name="ACTOR")
	@CollectionTable(name="ACTORS",
			joinColumns={
			@JoinColumn(name="TITLE", referencedColumnName="TITLE"),
			@JoinColumn(name="LAUNCH_DATE", referencedColumnName="LAUNCH_DATE")
			})
	private List<String> actors;
	
	public String getTitle() {
		return movieId.getTitle();
	}
	public void setTitle(String title) {
		movieId.setTitle(title);
	}
	public Date getLaunchDate() {
		return movieId.getLaunchDate();
	}
	public void setLaunchDate(Date launchDate) {
		movieId.setLaunchDate(launchDate);
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public List<String> getActors() {
		if(actors == null || actors.isEmpty()) {
			return new ArrayList<String>();
		}
		return actors;
	}
	public void setActors(List<String> actors) {
		this.actors = actors;
	}
	

}
