package es.everis.library.entity.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKS")
@DiscriminatorValue(value="BOOK")
@PrimaryKeyJoinColumn(name="WORK_ID")
public class Book extends Work implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String trick;
	
	public String getTrick() {
		return trick;
	}
	public void setTrick(String trick) {
		this.trick = trick;
	}
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.REFRESH)
	@JoinTable(
		      name="BOOK_WRITERS",
		      joinColumns=@JoinColumn(name="WORK_ID"),
		      inverseJoinColumns=@JoinColumn(name="WRITER_ID", referencedColumnName="ARTIST_ID"))
	private List<Artist> writers;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.REFRESH)
	@JoinTable(
		      name="BOOK_EDITORS",
		      joinColumns=@JoinColumn(name="WORK_ID"),
		      inverseJoinColumns=@JoinColumn(name="EDITOR_ID", referencedColumnName="ARTIST_ID"))
	private List<Artist> editors;
	
	public List<Artist> getWriters() {
		if(writers == null || writers.isEmpty()) {
			return new ArrayList<Artist>();
		}
		return writers;
	}
	public void setWriters(List<Artist> writers) {
		this.writers = writers;
	}
	public List<Artist> getEditors() {
		if(editors == null || editors.isEmpty()) {
			return new ArrayList<Artist>();
		}
		return editors;
	}
	public void setEditors(List<Artist> editors) {
		this.editors = editors;
	}
}
