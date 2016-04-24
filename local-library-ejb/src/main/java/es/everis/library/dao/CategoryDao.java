package es.everis.library.dao;

import java.util.List;

import es.everis.library.entity.business.Category;

public interface CategoryDao extends BaseDao<Category> {
	
	public Category findCategoryByName(String categortyName);
	public List<Category> findCategoryByWork(Integer workId);

}
