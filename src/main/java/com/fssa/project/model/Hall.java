package com.fssa.project.model;

public class Hall {
    private int hallId;
    private String hallName;
    private String hallLocation;
    private String mobileNumber;
    private String capacity;
    private String pricing;
    private String email; // Add the email field
    private String url;
    private String url1;
    private String url2;
    private String url3;
    private String url4;
    private String url5;
    private String url6;

    /**
     * Constructs a new Hall object with the specified attributes.
     *
     * @param hallName The name of the hall.
     * @param hallLocation The location of the hall.
     * @param mobileNumber The mobile number associated with the hall.
     * @param capacity The capacity of the hall.
     * @param pricing The pricing information for the hall.
     * @param email The email associated with the hall.
     * @param url The main URL for the hall.
     * @param url1 Additional URL 1 for the hall.
     * @param url2 Additional URL 2 for the hall.
     * @param url3 Additional URL 3 for the hall.
     * @param url4 Additional URL 4 for the hall.
     * @param url5 Additional URL 5 for the hall.
     * @param url6 Additional URL 6 for the hall.
     */
    
    public Hall(String hallName2, String hallLocation2, String mobileNumber2, String capacity2, String pricing2,
                String email, String url, String url1, String url2, String url3, String url4, String url5, String url6) {
        // Default constructor

    	/**
         * Constructs a new Hall object with the specified attributes.
         *
         * @param hallName The name of the hall.
         * @param hallLocation The location of the hall.
         * @param mobileNumber The mobile number associated with the hall.
         * @param capacity The capacity of the hall.
         * @param pricing The pricing information for the hall.
         * @param email The email associated with the hall.
         * @param url The main URL for the hall.
         * @param url1 Additional URL 1 for the hall.
         * @param url2 Additional URL 2 for the hall.
         * @param url3 Additional URL 3 for the hall.
         * @param url4 Additional URL 4 for the hall.
         * @param url5 Additional URL 5 for the hall.
         * @param url6 Additional URL 6 for the hall.
         */
    	
        this.hallName = hallName2;
        this.hallLocation = hallLocation2;
        this.mobileNumber = mobileNumber2;
        this.capacity = capacity2;
        this.pricing = pricing2;
        this.email = email; // Add this line for email
        this.url = url;
        this.url1 = url1;
        this.url2 = url2;
        this.url3 = url3;
        this.url4 = url4;
        this.url5 = url5;
        this.url6 = url6;

    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getPricing() {
        return pricing;
    }

    public void setPricing(String pricing) {
        this.pricing = pricing;
    }
    /**
     * Constructs a new Hall object with the specified attributes and ID.
     *
     * @param hallId The unique ID of the hall.
     * @param hallName The name of the hall.
     * @param hallLocation The location of the hall.
     * @param mobileNumber The mobile number associated with the hall.
     * @param capacity The capacity of the hall.
     * @param pricing The pricing information for the hall.
     * @param email The email associated with the hall.
     * @param url The main URL for the hall.
     * @param url1 Additional URL 1 for the hall.
     * @param url2 Additional URL 2 for the hall.
     * @param url3 Additional URL 3 for the hall.
     * @param url4 Additional URL 4 for the hall.
     * @param url5 Additional URL 5 for the hall.
     * @param url6 Additional URL 6 for the hall.
     */
    public Hall(int hallid, String hallName2, String hallLocation2, String mobileNumber2, String capacity2,
                String pricing2, String email, String url, String url1, String url2, String url3, String url4, String url5, String url6) {
        this.hallId = hallid;
        this.hallName = hallName2;
        this.hallLocation = hallLocation2;
        this.mobileNumber = mobileNumber2;
        this.capacity = capacity2;
        this.pricing = pricing2;
        this.email = email; // Add this line for email
        this.url = url;

        this.url1 = url1;
        this.url2 = url2;
        this.url3 = url3;
        this.url4 = url4;
        this.url5 = url5;
        this.url6 = url6;
    }
    /**
     * Default constructor for the Hall class.
     */
    public Hall() {
    }
    
    public Hall(int hallId2) {
        this.hallId = hallId2;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl1() {
        return url1;
    }

    public void setUrl1(String url1) {
        this.url1 = url1;
    }

    public String getUrl2() {
        return url2;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
    }

    public String getUrl3() {
        return url3;
    }

    public void setUrl3(String url3) {
        this.url3 = url3;
    }

    public String getUrl4() {
        return url4;
    }

    public void setUrl4(String url4) {
        this.url4 = url4;
    }

    public String getUrl5() {
        return url5;
    }

    public void setUrl5(String url5) {
        this.url5 = url5;
    }

    public String getUrl6() {
        return url6;
    }

    public void setUrl6(String url6) {
        this.url6 = url6;
    }
    // Getters and setters for attributes

    /**
     * Gets the ID of the hall.
     *
     * @return The hall ID.
     */
    public int getHallId() {
        return hallId;
    }
    /**
     * Sets the ID of the hall.
     *
     * @param hallId The new hall ID.
     */
    
    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    /**
     * Gets the name of the hall.
     *
     * @return The hall name.
     */
    public String getHallName() {
        return hallName;
    }
    /**
     * Sets the name of the hall.
     *
     * @param hallName The new hall name.
     */
    public void setHallName(String hallName) {
        this.hallName = hallName;
    }
    /**
     * Gets the location of the hall.
     *
     * @return The hall location.
     */
    public String getHallLocation() {
        return hallLocation;
    }
    /**
     * Sets the location of the hall.
     *
     * @param hallLocation The new hall location.
     */
    public void setHallLocation(String hallLocation) {
        this.hallLocation = hallLocation;
    }
    /**
     * Gets the mobile number associated with the hall.
     *
     * @return The mobile number.
     */

    public String getMobileNumber() {
        return mobileNumber;
    }
    /**
     * Sets the mobile number associated with the hall.
     *
     * @param mobileNumber The new mobile number.
     */

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    // Add getters and setters for the email field

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Hall [hallId=" + hallId + ", hallName=" + hallName + ", hallLocation=" + hallLocation
                + ", mobileNumber=" + mobileNumber + ", capacity=" + capacity + ", pricing=" + pricing + ", email=" + email
                + ", url=" + url + ", url1=" + url1 + ", url2=" + url2 + ", url3=" + url3 + ", url4=" + url4 + ", url5=" + url5
                + ", url6=" + url6 + "]";
    }
}
