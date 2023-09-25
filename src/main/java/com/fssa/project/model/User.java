package com.fssa.project.model;

public class User {
    private int userId; 
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

    public User() {

    }

    public User(String name, String mobileNumber, String email, String password, int isseller) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.password = password;
        this.isseller = isseller;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public int getIsseller() {
        return isseller;
    }

    public void setIsseller(int isseller) {
        this.isseller = isseller;
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
}
