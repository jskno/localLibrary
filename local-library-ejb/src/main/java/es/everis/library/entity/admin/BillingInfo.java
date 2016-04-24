package es.everis.library.entity.admin;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name="BILLING_INFO")
public class BillingInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="BILLING_ID")
	private String billingId;
	@Column(name="CREDIT_CARD_TYPE")
	private String creditCardType;
	@Column(name="CREDIT_CARD_NUMBER")
	private String creditCardNumber;
	@OneToOne(mappedBy="billingInfo", optional=false)
	private User user;
	
	@PrePersist
	public void generatePrimaryKey() {
		setBillingId(UUID.randomUUID().toString());
	}
	
	public String getBillingId() {
		return billingId;
	}
	public void setBillingId(String billingId) {
		this.billingId = billingId;
	}
	public String getCreditCardType() {
		return creditCardType;
	}
	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "BillingInfo [billingId=" + billingId + ", creditCardType="
				+ creditCardType + ", creditCardNumber=" + creditCardNumber
				+ ", user=" + user + "]";
	}
}
