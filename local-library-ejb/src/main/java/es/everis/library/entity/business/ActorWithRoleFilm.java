package es.everis.library.entity.business;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ACTOR_WITH_ROLE_FILM")
public class ActorWithRoleFilm implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ActorWithRoleFilmId actorWithRoleFilmId;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ACTOR_ROLE_NAME")
	private ActorRoleName actorRoleName;
	
	@Column(name="CHARACTER_NAME")
	private String characterName;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.REFRESH)
	@JoinColumn(name="ACTOR_ID", insertable=false, updatable=false)
	private Artist actor;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.REFRESH)
	@JoinColumn(name="WORK_ID", insertable=false, updatable=false)
	private Film film;
	
	// CONSTRUCTORS
	public ActorWithRoleFilm() {}
	
	public ActorWithRoleFilm(Artist actor, Film film) {
		
		// Set fields
		this.actor = actor;
		this.film = film;
		
		// Set identifier values
		this.actorWithRoleFilmId = new ActorWithRoleFilmId(
				actor.getArtistId(), film.getWorkId());
		
		// Guarantee referential integrity
//		actor.getActorWithRoleFilm().add(this);
		film.getActors().add(this);
	}

	public ActorWithRoleFilmId getActorWithRoleFilmId() {
		return actorWithRoleFilmId;
	}

	public void setActorWithRoleFilmId(ActorWithRoleFilmId actorWithRoleFilmId) {
		this.actorWithRoleFilmId = actorWithRoleFilmId;
	}

	public ActorRoleName getActorRoleName() {
		return actorRoleName;
	}

	public void setActorRoleName(ActorRoleName actorRoleName) {
		this.actorRoleName = actorRoleName;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public Artist getActor() {
		return actor;
	}

	public void setActor(Artist actor) {
		this.actor = actor;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}
	
}
