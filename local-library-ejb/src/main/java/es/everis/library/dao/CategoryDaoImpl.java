package es.everis.library.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import es.everis.library.entity.business.Category;

@Stateless
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {
	
	public CategoryDaoImpl() {
		super(Category.class);
	}

	@Override
	public Category findCategoryByName(String categortyName) {
		Query query = entityManager.createNamedQuery("findCategoryByName");
		query.setParameter("categoryName", "Pintura");
		return (Category) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findCategoryByWork(Integer workId) {
		Query query = entityManager.createNamedQuery("findCategoryByWork");
		query.setParameter("workId", 1);
		return (List<Category>) query.getSingleResult();
	}

//	public void addEntity(Category category) {
//		category.setModificationDate(new Date());
//		super.addEntity(category);
//	}
}
