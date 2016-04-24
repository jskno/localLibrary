package es.everis.library.entity.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import es.everis.library.entity.commom.GenericEntityBean;

@Entity
@Table(name="WORKS")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="WORK_TYPE",
		discriminatorType=DiscriminatorType.STRING, length=10)
public abstract class Work extends GenericEntityBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="WORK_ID")
	private Integer workId;
	
	@Column(name="TITLE")
	private String title;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="PUBLICATION_DATE")
	private Date publicationDate;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.REFRESH)
	@JoinColumn(name="ART_MOVEMENT_ID")
	private ArtMovement artMovement;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.REFRESH)
	@JoinTable(
		      name="WORK_CATEGORIES",
		      joinColumns=@JoinColumn(name="WORK_ID"),
		      inverseJoinColumns=@JoinColumn(name="CATEGORY_ID"))
	private Set<Category> categories;
	
	@OneToMany(mappedBy = "work", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Item> items;
	
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
	public List<Item> getItems() {
		if(items == null || items.isEmpty()) {
			return new ArrayList<Item>();
		}
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public ArtMovement getArtMovement() {
		return artMovement;
	}
	public void setArtMovement(ArtMovement artMovement) {
		this.artMovement = artMovement;
	}
	
	public Set<Category> getCategories() {
		if(categories == null || categories.isEmpty()) {
			return new HashSet<Category>();
		}
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	
	@Override
	public String toString() {
		return "Work [workId=" + workId + ", title=" + title
				+ ", publicationDate=" + publicationDate + ", artMovement="
				+ artMovement + "]";
	}
	
}
