package es.everis.library.entity.admin;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "STAFF_MEMBERS")
@DiscriminatorValue("STAFF")
public class StaffMember extends PersonRole implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="STAFF_ID")
	private int stafId;
	private String position;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="STARTING_DATE")
	private Date startingDate;
	
	public int getStafId() {
		return stafId;
	}
	public void setStafId(int stafId) {
		this.stafId = stafId;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Date getStartingDate() {
		return startingDate;
	}
	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

}
