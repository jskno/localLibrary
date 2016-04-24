package es.everis.library.ejb;

import java.util.List;

import es.everis.library.dao.WorkDao;
import es.everis.library.entity.business.Work;


public abstract class WorkServiceBean<E extends Work> extends BaseServiceBean<E>
				implements WorkService<E> {

	private WorkDao<E> workDao;
	
	public void setDaoToSuperClass() {
		super.setBaseDao(workDao);
	}
	
	public void setWorkDao(WorkDao<E> workDao) {
		this.workDao = workDao;
		super.setBaseDao(workDao);
	}
	
	@Override
	public List<E> findAllOrderByTitle(String title) {
		return workDao.findAllOrderByTitle(title);
	}

}
