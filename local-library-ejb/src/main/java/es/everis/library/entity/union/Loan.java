package es.everis.library.entity.union;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import es.everis.library.entity.business.Item;
import es.everis.library.entity.admin.User;

@Entity
@SequenceGenerator(name="LOAN_SEQUENCE_GENERATOR",
		sequenceName="LOAN_SEQUENCE", initialValue=1, allocationSize=1)
@Table(name="LOANS")
public class Loan implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator="LOAN_SEQUENCE_GENERATOR")
	@Column(name="LOAN_ID")
	private int loanId;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="PERSON_ID")
	private User user;
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.REFRESH)
	@JoinColumn(name="ITEM_ID")
	private Item item;
	@Temporal(TemporalType.DATE)
	@Column(name="INIT_LOAN_DATE")
	private Date initLoanDate;
	@Temporal(TemporalType.DATE)
	@Column(name="ENDING_LOAN_DATE")
	private Date endingLoanDate;
	
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Date getInitLoanDate() {
		return initLoanDate;
	}
	public void setInitLoanDate(Date initLoanDate) {
		this.initLoanDate = initLoanDate;
	}
	public Date getEndingLoanDate() {
		return endingLoanDate;
	}
	public void setEndingLoanDate(Date endingLoanDate) {
		this.endingLoanDate = endingLoanDate;
	}
	
	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", user=" + user + ", item=" + item
				+ ", initLoanDate=" + initLoanDate + ", endingLoanDate="
				+ endingLoanDate + "]";
	}
	
	

}
