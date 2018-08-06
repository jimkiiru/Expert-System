package com.expertsystem.model;

import javax.persistence.*;

@Entity
@Table(name="LoginCredentials")
public class LoginModel {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="logid",nullable=false)
	private int logid;
	@Column(name="Username",nullable=false)
	private String username;
	@Column(name="Password",nullable=false)
	private String password;
	@Column(name="Status",nullable=false)
	private String status;
	
	public int getLogid() {
		return logid;
	}
	public void setLogid(int logid) {
		this.logid = logid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
