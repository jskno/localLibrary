package es.everis.library.entity.admin;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import es.everis.library.entity.commom.Gender;

@Entity
@Table(name = "PERSONS")
@SecondaryTable(name="PERSONS_PICTURES",
		pkJoinColumns=@PrimaryKeyJoinColumn(name="PERSON_ID"))
public class Person implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATION_DATE")
	private Date creationDate;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PERSON_ID")
	private int personId;

	private String name;
	private String surname;
	private String email;
	@Enumerated(EnumType.ORDINAL)
	private Gender gender;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATE_OF_BIRTH")
	private Date birthday;
	@Transient
	private int age;
	private Boolean impaired;
	
	@Column(name = "PICTURE", table = "PERSONS_PICTURES")
	@Lob
	@Basic(fetch=FetchType.LAZY)
	private byte[] picture;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@Column(name="TEL_NUMBER")
	@CollectionTable(name="PHONE_NUMBERS",
			joinColumns=@JoinColumn(name="PERSON_ID"))
	private Collection<String> telephoneNumbers;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="HOMES",
			joinColumns=@JoinColumn(name="PERSON_ID"))
	private Set<Address> addresses;
	
	
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
//		setAge(UtilityClass.calculateAge(birthday));
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Boolean getImpaired() {
		return impaired;
	}
	public void setImpaired(Boolean impaired) {
		this.impaired = impaired;
	}
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	
	public Collection<String> getTelephoneNumbers() {
		return telephoneNumbers;
	}
	public void setTelephoneNumbers(Collection<String> telephoneNumbers) {
		this.telephoneNumbers = telephoneNumbers;
	}
	public Set<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", name=" + name + ", surname="
				+ surname + ", email=" + email + ", age=" + age 
				+ ", picture=" + Arrays.toString(picture)
				+ "]";
	}
	

}
