package es.everis.library.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class BaseDaoImpl<E> 
		implements BaseDao<E> {
	
	protected Class<E> entityClass;
	protected String entityName;
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	protected BaseDaoImpl(Class<E> entityClass){
        this.entityClass = entityClass;
        this.entityName = entityClass.getSimpleName();
    }
	
//	@SuppressWarnings("unchecked")
//	public BaseDaoImpl() {
//		ParameterizedType genericSuperclass = (ParameterizedType) getClass()
//	             .getGenericSuperclass();
//	        this.entityClass = (Class<E>) genericSuperclass
//	             .getActualTypeArguments()[0];
//	}
//	
//	@SuppressWarnings("unchecked")
//	public Class<E> getEntityClass() {
//		if (entityClass == null) {
//			entityClass = (Class<E>)GenericClassHelper.getFirstArgument(this, BaseDaoImpl.class);
//		}
//		return entityClass;
//	}
//	
//	public String getEntityName() {
//		if (entityName == null) {
//			entityName = getEntityClass().getSimpleName();
//		}
//		return entityName;
//	}
	
	public void addEntity(E entity) {
		entityManager.persist(entity);
		entityManager.flush();
	}
	
	public void removeEntity(E entity) {
//		entityManager.remove(entityManager.merge(entity));
		entityManager.remove(entity);
		entityManager.flush();
	}
	
	public E updateEntity(E entity) {
		E e = entityManager.merge(entity);
		entityManager.flush();
		return e;
	}
	
	public E findById(Serializable primaryKey) {
		return entityManager.find(entityClass, primaryKey);
	}
	
	public List<E> getAll() {
//		return find("Select model from " + getEntityName() + " as model");
		return find("Select model from " + entityClass.getSimpleName() + " as model");
	}
	
	@SuppressWarnings("unchecked")
	protected List<E> find(String sql) {
		Query queryObject = entityManager.createQuery(sql);
		return queryObject.getResultList();
	}
	
	protected EntityManager getEntityManager() {
		return entityManager;
	};
}
