package com.fssa.project.model;

import java.sql.Date;

public class Booking {
    private int id;
    private String userEmail; // Change data type to String
    private int hallId;
    private Date bookingDate;

    /**
     * Constructs a new Booking object with the specified user email, hall ID, and booking date.
     *
     * @param userEmail The email address of the user making the booking.
     * @param hallId    The ID of the hall being booked.
     * @param bookingDate The date on which the booking is made.
     */
    
    public Booking(String userEmail, int hallId, Date bookingDate) { // Change parameter type
        this.userEmail = userEmail;
        this.hallId = hallId;
        this.bookingDate = bookingDate;
    }

    // Getters and setters for the attributes
    /**
     * Gets the ID of the booking.
     *
     * @return The booking ID.
     */ 
    
    public int getId() {
        return id;
    }
    /**
     * Sets the ID of the booking.
     *
     * @param id The new booking ID.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Gets the email address of the user making the booking.
     *
     * @return The user's email address.
     */
    public String getUserEmail() { 
        return userEmail;
    }
    /**
     * Sets the email address of the user making the booking.
     *
     * @param userEmail The new email address of the user.
     */
    public void setUserEmail(String userEmail) { 
        this.userEmail = userEmail;
    }
    
    /**
     * Gets the ID of the hall being booked.
     *
     * @return The hall ID.
     */
    
    public int getHallId() {
        return hallId;
    }
    
    /**
     * Sets the ID of the hall being booked.
     *
     * @param hallId The new hall ID.
     */
    
    public void setHallId(int hallId) {
        this.hallId = hallId;
    }
    /**
     * Gets the date on which the booking is made.
     *
     * @return The booking date.
     */
    public Date getBookingDate() {
        return bookingDate;
    }
    /**
     * Sets the date on which the booking is made.
     *
     * @param bookingDate The new booking date.
     */
    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }
}
