package com.fssa.project.model;

import java.sql.Date;

public class Booking {
    private int id;
    private String userEmail; // Change data type to String
    private int hallId;
    private Date bookingDate;

    public Booking(String userEmail, int hallId, Date bookingDate) { // Change parameter type
        this.userEmail = userEmail;
        this.hallId = hallId;
        this.bookingDate = bookingDate;
    }

    // Getters and setters for the attributes

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserEmail() { // Change getter and setter method names
        return userEmail;
    }

    public void setUserEmail(String userEmail) { // Change parameter type
        this.userEmail = userEmail;
    }

    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }
}
