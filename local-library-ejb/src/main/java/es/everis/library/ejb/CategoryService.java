package es.everis.library.ejb;

import java.util.List;

import es.everis.library.entity.business.Category;

public interface CategoryService extends BaseService<Category> {
	
	public Category findCategoryByName(String categortyName);
	public List<Category> findCategoryByWork(Integer workId);

}
