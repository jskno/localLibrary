package es.everis.library.entity.admin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import es.everis.library.entity.union.Loan;

@Entity
@Table(name = "USERS")
@DiscriminatorValue("USER")
public class User extends PersonRole implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="USER_CARD_ID")
	private int userCardId;
	@OneToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="BILLING_ID")
	private BillingInfo billingInfo;
	@OneToMany(mappedBy="user")
	private List<Loan> loans;

	public int getUserCardId() {
		return userCardId;
	}

	public void setUserCardId(int userCardId) {
		this.userCardId = userCardId;
	}

	public BillingInfo getBillingInfo() {
		return billingInfo;
	}

	public void setBillingInfo(BillingInfo billingInfo) {
		this.billingInfo = billingInfo;
	}

	public List<Loan> getLoans() {
		if(loans == null || loans.isEmpty()) {
			return new ArrayList<Loan>();
		}
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}

	@Override
	public String toString() {
		return "User [userCardId=" + userCardId + ", billingInfo="
				+ billingInfo + "]";
	}

}
