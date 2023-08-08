package Redefine.model;

public class Halls {
   private int hall_id;
   private String hall_name;
   private String hall_location;
   private int mobile_no;
public Halls(int hall_id, String hall_name, String hall_location, int mobile_no) {
	super();
	this.hall_id = hall_id;
	this.hall_name = hall_name;
	this.hall_location = hall_location;
	this.mobile_no = mobile_no;
}
public int getHall_id() {
	return hall_id;
}
public void setHall_id(int hall_id) {
	this.hall_id = hall_id;
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
public void setMobile_no(int mobile_no) {
	this.mobile_no = mobile_no;
}
   

}
