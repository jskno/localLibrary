package es.everis.library.entity.admin;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	@Column(name="HOME_STREET")
	private String street;
	@Column(name="HOME_CITY")
	private String city;
	@Column(name="HOME_STATE")
	private String state;
	@Column(name="HOME_ZIP")
	private String zipCode;
}
