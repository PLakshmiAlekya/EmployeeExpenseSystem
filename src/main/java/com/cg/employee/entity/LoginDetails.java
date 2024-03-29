package com.cg.employee.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LoginDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String userName;
	private String password;
	private String role;
	
	private boolean LoggedIn;
	public boolean isLoggedIn() {
		return LoggedIn;
	}
	public LoginDetails() {
		super();
	}
	public LoginDetails(String userName, String password, String role, boolean loggedIn) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
		LoggedIn = loggedIn;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setLoggedIn(boolean loggedIn) {
		LoggedIn = loggedIn;
	}
	
	
}

	