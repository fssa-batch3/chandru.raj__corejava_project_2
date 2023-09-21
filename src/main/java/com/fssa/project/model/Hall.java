package com.fssa.project.model;

public class Hall {
	private int hallId;
	
	private String hallName;
	private String hallLocation;
	private String mobileNumber;
	private String capacity;
	private String pricing;
	private String url;
	private String url1;
	private String url2;
	private String url3;
	private String url4;
	private String url5;
	private String url6;

	public Hall(String hallName2, String hallLocation2, String mobileNumber2, String capacity2, String pricing2,
			String url, String url1, String url2, String url3, String url4, String url5, String url6) {
		// Default constructor
		
		this.hallName = hallName2;
		this.hallLocation = hallLocation2;
		this.mobileNumber = mobileNumber2;
		this.pricing = pricing2;
		this.capacity = capacity2;
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

	public Hall(int hallid, String url, String hallName2, String hallLocation2, String mobileNumber2, String capacity2,
			String pricing2, String url1, String url2, String url3, String url4, String url5, String url6) {
		this.hallId = hallid;
				this.hallName = hallName2;
		this.hallLocation = hallLocation2;
		this.mobileNumber = mobileNumber2;
		this.capacity = capacity2;
		this.pricing = pricing2;
		this.url = url;

		this.url1 = url1;
		this.url2 = url2;
		this.url3 = url3;
		this.url4 = url4;
		this.url5 = url5;
		this.url6 = url6;
	}

	public Hall() {
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
		return "Hall{" + "hallId=" + hallId + ", hallName='" + hallName + '\'' + ", hallLocation='" + hallLocation
				+ '\'' + ", mobileNumber='" + mobileNumber + '\'' + pricing + capacity + url + url1 + url2 + url3 + url4 + url5 + url6 +  '}';
	}
}
