package es.everis.library.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.everis.library.entity.commom.GenericEntityBean;

/**
 * @author Buhake Sindi
 * @since 24 February 2014
 *
 */
public abstract class BaseJPADAO<E extends GenericEntityBean> extends BaseDaoImpl<E> {
 
	 @PersistenceContext
	 private EntityManager entityManager;
	  
	 /**
	  * @param persistentClass
	  */
	 protected BaseJPADAO(Class<E> persistentClass) {
	  super(persistentClass);
	 }
	 
	 /* (non-Javadoc)
	  * @see za.co.sindi.dao.JPAGenericDAO#getEntityManager()
	  */
	 @Override
	 protected final EntityManager getEntityManager() {
	  return entityManager;
	 }
}
