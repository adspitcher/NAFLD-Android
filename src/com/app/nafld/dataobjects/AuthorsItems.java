package com.app.nafld.dataobjects;

public class AuthorsItems {
	private String drname;
	private String department;
	private String qualification;
	private String location;
	public AuthorsItems(String drname, String department, String qualification,
			String location) {
		super();
		this.drname = drname;
		this.department = department;
		this.qualification = qualification;
		this.location = location;
	}
	public String getDrname() {
		return drname;
	}
	public void setDrname(String drname) {
		this.drname = drname;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
