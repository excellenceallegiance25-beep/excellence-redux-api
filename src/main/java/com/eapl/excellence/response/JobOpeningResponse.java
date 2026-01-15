package com.eapl.excellence.response;

public class JobOpeningResponse {

	private Integer id;
	private String title;
	private String department;
	private String location;
	private String type;

	public JobOpeningResponse() {
	}

	public JobOpeningResponse(Integer id, String title, String department, String location, String type) {
		this.id = id;
		this.title = title;
		this.department = department;
		this.location = location;
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "JobOpeningResponse [id=" + id + ", title=" + title + ", department=" + department + ", location="
				+ location + ", type=" + type + "]";
	}
}
