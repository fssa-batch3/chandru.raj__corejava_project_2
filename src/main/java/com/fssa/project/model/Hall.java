package com.fssa.project.model;

public class Hall {
    private String hallName;
    private String hallLocation;
    private String mobileNumber;

    public Hall() {
        // Default constructor
    }

    public Hall(String hallName, String hallLocation, String mobileNumber) {
        this.hallName = hallName;
        this.hallLocation = hallLocation;
        this.mobileNumber = mobileNumber;
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

	public void setHallId(int int1) {
		// TODO Auto-generated method stub
		
	}

	public int getHallId() {
		// TODO Auto-generated method stub
		return 0;
	}
}
