package com.expertsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity 
@Table(name="Experts")
public class ExpertModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ExpertId", nullable = false)
	private int expertId;
	@Column(name = "Surname", nullable = true)
	 private String surname;
	@Column(name = "FirstName", nullable = true)
	 private String fname;
	@Column(name = "LastName", nullable = true)
	 private String lname;
	@Column(name = "EmailAddress", nullable = false,unique=true)
	 private String emailaddress;
	@Min(8)
	@Column(name = "PhoneNumber", nullable = false,unique=true)
	 private String phonenum;
	@Column(name = "JobDescription", nullable = false)
	 private String jobDescription;
	@Column(name = "Department", nullable = false)
	 private String department;
	@Column(name = "County", nullable = false)
	 private String county;
	@Column(name = "Status", nullable = false)
	 private String status;
	@Column(name = "Password", nullable = false)
	 private String password;
	@Column(name = "profilePicture", nullable = false)
	 private String profilePic;
	
	public int getExpertId() {
		return expertId;
	}
	public void setExpertId(int expertId) {
		this.expertId = expertId;
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
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
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
