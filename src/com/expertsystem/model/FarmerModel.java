package com.expertsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="Farmers")
public class FarmerModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FarmerId", nullable = false)
	private int farmerId;
	@Column(name = "Surname", nullable = false)
	 private String surname;
	@Column(name = "FirstName", nullable = false)
	 private String fname;
	@Column(name = "LastName", nullable = false)
	 private String lname;
	@Column(name = "EmailAddress", nullable = true,unique=true)
	 private String emailaddress;
	@Column(name = "PhoneNumber", nullable = false,unique=true)
	 private String phonenum;
	@Column(name = "Occupation", nullable = false)
	 private String occupation;
	@Column(name = "County", nullable = false)
	 private String county;
	@Column(name = "NationalId", nullable = false,unique=true)
	 private String nationalId;
	@Column(name = "Status", nullable = false)
	 private String status;
	@Column(name = "Password", nullable = false)
	 private String password;
	@Column(name = "profilePicture", nullable = false)
	 private String profilePic;
	
	public int getFarmerId() {
		return farmerId;
	}
	public void setFarmerId(int farmerId) {
		this.farmerId = farmerId;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmailaddress() {
		return emailaddress;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getNationalId() {
		return nationalId;
	}
	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}	
}
