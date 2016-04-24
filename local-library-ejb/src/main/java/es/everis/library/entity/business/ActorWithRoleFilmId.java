package es.everis.library.entity.business;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ActorWithRoleFilmId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="ACTOR_ID")
	private int actorId;
	@Column(name="WORK_ID")
	private int filmId;

	public ActorWithRoleFilmId() { }
	
	public ActorWithRoleFilmId(int actorId, int filmId) {
		this.actorId = actorId;
		this.filmId = filmId;
	}

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + actorId;
		result = prime * result + filmId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActorWithRoleFilmId other = (ActorWithRoleFilmId) obj;
		if (actorId != other.actorId)
			return false;
		if (filmId != other.filmId)
			return false;
		return true;
	}

}
