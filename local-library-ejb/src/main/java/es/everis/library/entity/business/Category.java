package es.everis.library.entity.business;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import es.everis.library.entity.commom.GenericEntityBean;

@Entity
@NamedQueries({
	@NamedQuery(
			name="findCategoryByName",
			query="SELECT c FROM Category c WHERE c.categoryName LIKE :categoryName ORDER BY c.categoryId"
	),
	@NamedQuery(
			name="findCategoryByWork",
			query="SELECT c FROM Category c JOIN c.works w WHERE w.workId = ?1"
	)
})
@Table(name="CATEGORIES")
public class Category extends GenericEntityBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CATEGORY_ID")
	private Integer categoryId;
	
	@Column(name="CATEGORY_NAME")
	private String categoryName;
	
	@Temporal(TemporalType.DATE)
	@Column(name="MODIFICATION_DATE")
	private Date modificationDate;
	
	@ManyToMany(mappedBy="categories")
	private Set<Work> works;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FATHER_ID", referencedColumnName="CATEGORY_ID")
	private Category father;
	
	@OneToMany
	@JoinColumn(name="CATEGORY_ID", referencedColumnName="FATHER_ID")
	private Set<Category> subCategories;
	
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Category getFather() {
		if(father == null) {
			return new Category();
		} else {
			return father;
		}
	}
	public void setFather(Category father) {
		this.father = father;
	}
	
	public Date getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
	public Set<Work> getWorks() {
		if(works == null || works.isEmpty()) {
			return new HashSet<Work>();
		}
		return works;
	}
	public void setWorks(Set<Work> works) {
		this.works = works;
	}
	public Set<Category> getSubCategories() {
		if(subCategories == null || subCategories.isEmpty()) {
			return new HashSet<Category>();
		}
		return subCategories;
	}
	public void setSubCategories(Set<Category> subCategories) {
		this.subCategories = subCategories;
	}
	
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName="
				+ categoryName + ", father=" + father + "]";
	}

}
