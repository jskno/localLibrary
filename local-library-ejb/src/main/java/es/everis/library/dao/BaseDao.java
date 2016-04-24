package es.everis.library.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<E> {
	
	public void addEntity(E entity);
	public void removeEntity(E entity);
	public E updateEntity(E entity);
	public E findById(Serializable primariKey);
	public List<E> getAll();

}
