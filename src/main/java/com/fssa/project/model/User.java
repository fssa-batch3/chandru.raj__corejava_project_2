package com.fssa.project.model;

import java.time.LocalDate;

public class User {
    private String name;
    private String gender;
    private String mobileNumber;
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    private boolean isActive = true;
    private boolean isDeleted = false;

    public User(String name, String gender, String mobileNumber, LocalDate dateOfBirth, String email, String password) {
        this.name = name;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;
    }

    // Constructors, getters, setters, and other methods...

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
}
