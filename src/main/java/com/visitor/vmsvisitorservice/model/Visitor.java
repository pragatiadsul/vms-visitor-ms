package com.visitor.vmsvisitorservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "visitor")
public class Visitor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotEmpty(message = "first name cannot be empty")
	private String name;

	@Email
	@NotEmpty
	private String email;

	// @Pattern(regexp = "([0-9]{9}")
	private String mobileNo;

	@NotEmpty(message = "address cannot be empty")
	private String address;

	@NotEmpty(message = "idProof cannot be empty")
	private String idProof;

	@NotEmpty(message = "contactPersonName cannot be empty")
	private String contactPersonName;

	@NotEmpty(message = "contactPersonEmail cannot be empty")
	private String contactPersonEmail;
	// private String reference;

	@NotEmpty(message = "reasonForVisit cannot be empty")
	private String reasonForVisit;

	@Column(name = "status", nullable = false, columnDefinition = "int default 0")
	private int status;

	private String contactPersonMobileNo;

	public Visitor() {
		super();
	}

	public Visitor(long id, @NotEmpty(message = "first name cannot be empty") String name, @Email String email,
			String mobileNo, @NotEmpty(message = "address cannot be empty") String address,
			@NotEmpty(message = "idProof cannot be empty") String idProof,
			@NotEmpty(message = "contactPersonName cannot be empty") String contactPersonName,
			@NotEmpty(message = "contactPersonEmail cannot be empty") String contactPersonEmail,
			@NotEmpty(message = "reasonForVisit cannot be empty") String reasonForVisit, int status,
			String contactPersonMobileNo) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobileNo = mobileNo;
		this.address = address;
		this.idProof = idProof;
		this.contactPersonName = contactPersonName;
		this.contactPersonEmail = contactPersonEmail;
		this.reasonForVisit = reasonForVisit;
		this.status = status;
		this.contactPersonMobileNo = contactPersonMobileNo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	public String getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public String getContactPersonEmail() {
		return contactPersonEmail;
	}

	public void setContactPersonEmail(String contactPersonEmail) {
		this.contactPersonEmail = contactPersonEmail;
	}

	public String getReasonForVisit() {
		return reasonForVisit;
	}

	public void setReasonForVisit(String reasonForVisit) {
		this.reasonForVisit = reasonForVisit;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getContactPersonMobileNo() {
		return contactPersonMobileNo;
	}

	public void setContactPersonMobileNo(String contactPersonMobileNo) {
		this.contactPersonMobileNo = contactPersonMobileNo;
	}

}