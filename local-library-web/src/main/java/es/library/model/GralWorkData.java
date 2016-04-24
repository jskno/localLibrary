package es.library.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.enterprise.inject.Model;

import es.everis.library.entity.business.ArtMovement;
import es.everis.library.entity.business.Book;
import es.everis.library.entity.business.Category;
import es.everis.library.entity.business.Film;
import es.everis.library.entity.business.Work;
import es.everis.library.entity.business.WorkType;

@Model
public class GralWorkData {
	
	private Integer id;
	private String title;
	private Date publicationDate;
	private Integer artMovementId;
	private List<Integer> categoriesId;
	private String workType;
	private double duration;
	private String trick;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public String getTrick() {
		return trick;
	}
	public void setTrick(String trick) {
		this.trick = trick;
	}

	public Work fromData() {
		Work work = null;
		if(WorkType.BOOK.toString().equals(getWorkType())) {
			work = new Book();
			((Book) work).setTrick(getTrick());
		} else if(WorkType.FILM.toString().equals(getWorkType())) {
			work = new Film();
			((Film) work).setDuration(getDuration());
		}
		setCommomFields(work);
		return work;
	}
	
	private void setCommomFields(Work work) {
		work.setWorkId(getId());
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
		work.setCategories(categories);
	}

	public static GralWorkData toData(Book book) {
		GralWorkData gralWorkData = setWorkFields(book);
		gralWorkData.setTrick(book.getTrick());
		return gralWorkData;
	}
	
	public static GralWorkData toData(Film film) {
		GralWorkData gralWorkData = setWorkFields(film);
		gralWorkData.setDuration(film.getDuration());
		return gralWorkData;
	}
	
	public static GralWorkData setWorkFields (Work work) {
		GralWorkData gralWorkData = new GralWorkData();
		gralWorkData.setId(work.getWorkId());
		gralWorkData.setTitle(work.getTitle());
		gralWorkData.setPublicationDate(work.getPublicationDate());
		gralWorkData.setArtMovementId(work.getArtMovement().getArtMovementId());
		List<Integer> categoriesId = gralWorkData.getCategoriesId();
		for(Category category : work.getCategories()) {
			categoriesId.add(category.getCategoryId());
		}
		return gralWorkData;
	}
}
