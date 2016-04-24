package es.library.data.to.view;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import es.everis.library.ejb.CategoryService;
import es.everis.library.entity.business.Category;

@Named("categoryList")
@SessionScoped
public class CategoryList implements Serializable {

   private static final long serialVersionUID = 1L;
   
   @EJB
   private CategoryService categoryService;

   private Map<Integer, String> categories;

   @PostConstruct
   public void initCategoryList() {
	   categories = new HashMap<Integer, String>();
	   for(Category category : categoryService.getAll()) {
		   categories.put(category.getCategoryId(), category.getCategoryName());
	   }
   }

	public Map<Integer, String> getCategories() {
		initCategoryList();
		return categories;
	}
	
	public void setCategories(Map<Integer, String> categories) {
		this.categories = categories;
	}
}
