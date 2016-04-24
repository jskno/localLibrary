package es.everis.library.dao;

import java.util.List;

import es.everis.library.entity.business.Work;

public interface WorkDao<E extends Work> extends BaseDao<E> {

	public List<E> findAllOrderByTitle(String title);
}
