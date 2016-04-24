package es.everis.library.ejb;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E> {
	
	public void addEntity(E entity);
	public void removeEntity(E entity);
	public void updateEntity(E entity);
	public E findById(Serializable	primaryKey);
	public List<E> getAll();

}
