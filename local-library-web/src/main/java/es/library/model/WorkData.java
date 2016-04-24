package es.library.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.enterprise.inject.Model;

import es.everis.library.entity.business.ArtMovement;
import es.everis.library.entity.business.Category;
import es.everis.library.entity.business.Work;
import es.library.data.to.view.WorkTypes;

@Model
public abstract class WorkData {
	
	private Integer workId;
	private String title;
	private Date publicationDate;
	private Integer artMovementId;
	private List<Integer> categoriesId;
	private WorkTypes workType;
	
	public Integer getWorkId() {
		return workId;
	}
	public void setWorkId(Integer workId) {
		this.workId = workId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	public Integer getArtMovementId() {
		return artMovementId;
	}
	public void setArtMovementId(Integer artMovementId) {
		this.artMovementId = artMovementId;
	}
	public List<Integer> getCategoriesId() {
		if(categoriesId == null || categoriesId.isEmpty()) {
			return new ArrayList<Integer>();
		} else {
			return categoriesId;
		}
	}
	public void setCategoriesId(List<Integer> categoriesId) {
		this.categoriesId = categoriesId;
	}
	
	public WorkTypes getWorkType() {
		return workType;
	}
	public void setWorkType(WorkTypes workType) {
		this.workType = workType;
	}
	
	public void fromData(Work work) {
		work.setWorkId(getWorkId());
		work.setTitle(getTitle());
		work.setPublicationDate(new Date());
		ArtMovement artMovement = new ArtMovement();
		artMovement.setArtMovementId(getArtMovementId());
		work.setArtMovement(artMovement);
		Set<Category> categories = work.getCategories();
		for(Integer categoryDataId : getCategoriesId()) {
			Category category = new Category();
			category.setCategoryId(categoryDataId);
			categories.add(category);
		}
	}

	public void toData(Work work) {
		setWorkId(work.getWorkId());
		setTitle(work.getTitle());
		setPublicationDate(work.getPublicationDate());
		setArtMovementId(work.getArtMovement().getArtMovementId());
		List<Integer> categoriesId = getCategoriesId();
		for(Category category : work.getCategories()) {
			categoriesId.add(category.getCategoryId());
		}
	}
}
