package com.example.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CONTACT_DETAILS")
public class Contact {
	
	@Id
	@GeneratedValue
	@Column(name= "CONTACT_ID")
	private Integer contactId;
     
	@Column(name= "CONTACT_NAME")
	private String contactname;
	
	@Column(name= "CONTACT_EMAIL")
	private String contactEmail;
	
	@Column(name= "CONTACT_NUMBER")
	private Long contactNumber;
	
	@CreationTimestamp
	@Column(name= "CREATE_DATE" ,updatable=false)
	private LocalDate createData;
	
	@UpdateTimestamp
	@Column(name= "UPDATE_DATE" , insertable=false)
	private LocalDate updatedate;
	
	@Column(name= "ACTIVE_SW")
	private String activeSw;
	
	

	public Contact() {
		super();
	}

	public Contact(Integer contactId, String contactname, String contactEmail, Long contactNumber, LocalDate createData,
			LocalDate updatedate, String activeSw) {
		super();
		this.contactId = contactId;
		this.contactname = contactname;
		this.contactEmail = contactEmail;
		this.contactNumber = contactNumber;
		this.createData = createData;
		this.updatedate = updatedate;
		this.activeSw = activeSw;
	}

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public String getContactname() {
		return contactname;
	}

	public void setContactname(String contactname) {
		this.contactname = contactname;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public LocalDate getCreateData() {
		return createData;
	}

	public void setCreateData(LocalDate createData) {
		this.createData = createData;
	}

	public LocalDate getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(LocalDate updatedate) {
		this.updatedate = updatedate;
	}

	public String getActiveSw() {
		return activeSw;
	}

	public void setActiveSw(String activeSw) {
		this.activeSw = activeSw;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", contactname=" + contactname + ", contactEmail=" + contactEmail
				+ ", contactNumber=" + contactNumber + ", createData=" + createData + ", updatedate=" + updatedate
				+ ", activeSw=" + activeSw + "]";
	}
	
	
	


}
