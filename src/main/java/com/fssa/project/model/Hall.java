package com.fssa.project.model;

public class Hall {
    private int hallId;
    private String hallName;
    private String hallLocation;
    private String mobileNumber;

    public Hall() {
        // Default constructor
    }

    public Hall(int hallId, String hallName, String hallLocation, String mobileNumber) {
        this.hallId = hallId;
        this.hallName = hallName;
        this.hallLocation = hallLocation;
        this.mobileNumber = mobileNumber;
    }

    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public String getHallLocation() {
        return hallLocation;
    }

    public void setHallLocation(String hallLocation) {
        this.hallLocation = hallLocation;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "Hall{" +
                "hallId=" + hallId +
                ", hallName='" + hallName + '\'' +
                ", hallLocation='" + hallLocation + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}
