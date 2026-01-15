package com.eapl.excellence.response;

public class CommonDetailResponse {

	private Integer id;
	private String name;
	private String abbreviation;
	private String description;
	private boolean status;

	public CommonDetailResponse() {
	}

	public CommonDetailResponse(Integer id, String name, String abbreviation, String description, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.abbreviation = abbreviation;
		this.description = description;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "RoleDetailResponse [id=" + id + ", name=" + name + ", abbreviation=" + abbreviation + ", description="
				+ description + ", status=" + status + "]";
	}

}
