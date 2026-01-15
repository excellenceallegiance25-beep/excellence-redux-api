package com.eapl.excellence.request;

public class PartnerDetailRequest {

	private String indicator;
	private int id;
	private String name;
	private String type;
	private String logo;
	private String color;
	private String email;
	private String phone;
	private String services;
	private boolean status;
	private String profilePicture; 
	private String profilePictureType;
	
	public PartnerDetailRequest() {
		
	}

	public PartnerDetailRequest(String indicator, int id, String name, String type, String logo, String color,
			String email, String phone, String services, boolean status, String profilePicture,
			String profilePictureType) {
		super();
		this.indicator = indicator;
		this.id = id;
		this.name = name;
		this.type = type;
		this.logo = logo;
		this.color = color;
		this.email = email;
		this.phone = phone;
		this.services = services;
		this.status = status;
		this.profilePicture = profilePicture;
		this.profilePictureType = profilePictureType;
	}

	public String getIndicator() {
		return indicator;
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getProfilePictureType() {
		return profilePictureType;
	}

	public void setProfilePictureType(String profilePictureType) {
		this.profilePictureType = profilePictureType;
	}

	@Override
	public String toString() {
		return "PartnerDetailRequest [indicator=" + indicator + ", id=" + id + ", name=" + name + ", type=" + type
				+ ", logo=" + logo + ", color=" + color + ", email=" + email + ", phone=" + phone + ", services="
				+ services + ", status=" + status + ", profilePicture=" + profilePicture + ", profilePictureType="
				+ profilePictureType + "]";
	}
	
	
	
	
}
