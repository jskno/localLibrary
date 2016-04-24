package es.everis.library.ejb;


import java.io.Serializable;
import java.util.List;

import es.everis.library.dao.BaseDao;

public abstract class BaseServiceBean<E> implements BaseService<E>{
	
	private BaseDao<E> baseDao;
	
	public void setBaseDao(BaseDao<E> baseDao) {
		this.baseDao = baseDao;
	}
	
	public void addEntity(E entity) {
		baseDao.addEntity(entity);
	}

	public void removeEntity(E entity) {
		baseDao.removeEntity(entity);
	}

	public void updateEntity(E entity) {
		baseDao.updateEntity(entity);
	}

	public E findById(Serializable primaryKey) {
		return baseDao.findById(primaryKey);
	}

	public List<E> getAll() {
		return baseDao.getAll();
	}
}
