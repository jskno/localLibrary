package es.everis.library.ejb;

import java.util.List;

import es.everis.library.entity.business.Work;

public interface WorkService<E extends Work> extends BaseService<E> {
	
	public List<E> findAllOrderByTitle(String title);

}
