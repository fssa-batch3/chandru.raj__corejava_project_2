package com.fssa.project.model;

import java.time.LocalDate;

public class User {
	private String name;

	private String mobileNumber;

	private String email;
	private String password;
	public int isseller;
	private boolean isActive = true;
	private boolean isDeleted = false;

	public User(String name, String mobileNumber, String email, String password) {
		this.name = name;

		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;

	}

	// Constructors, getters, setters, and other methods...

//    public User(String name2, String mobileNumber2, int i, String email2, String password2) {
//	}
//    
	public User() {

	}

	public User(String name, String mobileNumber, String email, String password, int setType) {
		this.name = name;
		this.isseller = setType;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean active) {
		isActive = active;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean deleted) {
		isDeleted = deleted;
	}

	public int getUserId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setUserId(int userId) {
		// TODO Auto-generated method stub

	}

	public int isIsseller() {
		return isseller;
	}

	public void setIsseller(int isseller) {
		this.isseller = isseller;
	}
}
