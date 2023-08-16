package com.fssa.redefine.model;

public class Halls {
  
   private String hall_name;
   private String hall_location;
   private int mobile_no;
public Halls(String hall_name, String hall_location, int i) {
	super();
	
	this.hall_name = hall_name;
	this.hall_location = hall_location;
	this.mobile_no = i;
}
public Halls() {
	// TODO Auto-generated constructor stub
}
public String getHall_name() {
	return hall_name;
}
public void setHall_name(String hall_name) {
	this.hall_name = hall_name;
}
public String getHall_location() {
	return hall_location;
}
public void setHall_location(String hall_location) {
	this.hall_location = hall_location;
}
public int getMobile_no() {
	return mobile_no;
}
public void setMobile_no(String string) {
	this.mobile_no = mobile_no;
}

   

}
