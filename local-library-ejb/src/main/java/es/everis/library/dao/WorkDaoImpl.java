package es.everis.library.dao;

import java.util.List;

import javax.persistence.Query;

import es.everis.library.entity.business.Work;

public abstract class WorkDaoImpl<E extends Work>
			extends BaseDaoImpl<E> implements WorkDao<E> {
	
	protected WorkDaoImpl(Class<E> entityClass) {
		super(entityClass);
	}
	
	public List<E> findAllOrderByTitle(String title) {
		
		Query query = entityManager.createQuery
				("Select d from " + entityName + " d order by d.title");
		
		@SuppressWarnings("unchecked")
		List<E> works = (List<E>) query.getResultList();
		
		return works;
	}

}
