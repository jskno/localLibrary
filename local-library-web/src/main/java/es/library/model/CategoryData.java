package es.library.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.inject.Model;

import es.everis.library.entity.business.Category;

@Model
public class CategoryData {
	
	private Integer id;
	private String name;
	private Integer fatherId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getFatherId() {
		return fatherId;
	}
	public void setFatherId(Integer fatherId) {
		this.fatherId = fatherId;
	}
	
	public static Category fromData(CategoryData categoryData) {
		if(categoryData == null) {
			return null;
		}
		Category category = new Category();
		category.setCategoryId(categoryData.getId());
		category.setCategoryName(categoryData.getName());

		if(categoryData.getFatherId() != null) {
			Category fatherCategory = new Category();
			fatherCategory.setCategoryId(categoryData.getFatherId());
			category.setFather(fatherCategory);
		}
		
		category.setModificationDate(new Date());
		
		return category;
	}
	
	public static CategoryData toData(Category category) {
		if(category == null) {
			return null;
		}
		CategoryData categoryData = new CategoryData();
		categoryData.setId(category.getCategoryId());
		categoryData.setName(category.getCategoryName());
		categoryData.setFatherId(category.getFather().getCategoryId());
		return categoryData;
	}
	
	public static List<CategoryData> toData(List<Category> categories) {
		List<CategoryData> categoriesData = new ArrayList<CategoryData>();
		for(Category category : categories) {
			categoriesData.add(toData(category));
		}
		return categoriesData;
	}


}
