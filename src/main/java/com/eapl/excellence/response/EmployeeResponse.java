package com.eapl.excellence.response;

public class EmployeeResponse {

	private Integer id;
	private String name;
	private String role;
	private String avatar;
	private String bio;
	private String fullBio;
	private String expertise;
	private String linkedin;
	private String education;

	EmployeeResponse() {
	}

	public EmployeeResponse(Integer id, String name, String role, String avatar, String bio, String fullBio,
			String expertise, String linkedin, String education) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.avatar = avatar;
		this.bio = bio;
		this.fullBio = fullBio;
		this.expertise = expertise;
		this.linkedin = linkedin;
		this.education = education;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getFullBio() {
		return fullBio;
	}

	public void setFullBio(String fullBio) {
		this.fullBio = fullBio;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	@Override
	public String toString() {
		return "EmployeeResponse [id=" + id + ", name=" + name + ", role=" + role + ", avatar=" + avatar + ", bio="
				+ bio + ", fullBio=" + fullBio + ", expertise=" + expertise + ", linkedin=" + linkedin + ", education="
				+ education + "]";
	}

}
