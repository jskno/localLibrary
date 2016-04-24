package es.everis.library.ejb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import es.everis.library.dao.CategoryDao;
import es.everis.library.entity.business.Category;

@Stateless
public class CategoryServiceBean extends BaseServiceBean<Category>
			implements CategoryService {

//	@Inject
	@EJB
	private CategoryDao categoryDao;
	
	@PostConstruct
	public void setDaoToSuperClass() {
		super.setBaseDao(categoryDao);
	}
	
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public Category findCategoryByName(String categortyName) {
		return categoryDao.findCategoryByName(categortyName);
	}

	@Override
	public List<Category> findCategoryByWork(Integer workId) {
		return categoryDao.findCategoryByWork(workId);
	}

}
