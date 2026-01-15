package com.eapl.excellence.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfileUpdateRequest {

	private Integer id;

	// Profile fields
	private String name;
	private String email;
	private String phone;
	private String title;
	private String company;
	private String location;
	private String bio;
	private String education;
	private String website;
	private String github;
	private String linkedin;
	private boolean status;
	private String role;
	private String roleType;

	// Settings
	private Boolean notificationsEmail;
	private Boolean notificationsPush;
	private Boolean notificationsMarketing;
	private Boolean notificationsSecurity;
	private Boolean twoFactorEnabled;

	// Skills
	private List<SkillAddRequest> skills;

	// Password change
	private String currentPassword;
	private String newPassword;

	// Profile picture (base64 string or file reference)
	private String profilePicture; // base64 encoded image
	private String profilePictureType; // image/jpeg, image/png, etc.

	private String department;
	private String position;

	private String indicator;

	public ProfileUpdateRequest() {
	}

	public ProfileUpdateRequest(Integer id, String name, String email, String phone, String title, String company,
			String location, String bio, String education, String website, String github, String linkedin,
			boolean status, String role, String roleType, Boolean notificationsEmail, Boolean notificationsPush,
			Boolean notificationsMarketing, Boolean notificationsSecurity, Boolean twoFactorEnabled,
			List<SkillAddRequest> skills, String currentPassword, String newPassword, String profilePicture,
			String profilePictureType, String department, String position, String indicator) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.title = title;
		this.company = company;
		this.location = location;
		this.bio = bio;
		this.education = education;
		this.website = website;
		this.github = github;
		this.linkedin = linkedin;
		this.status = status;
		this.role = role;
		this.roleType = roleType;
		this.notificationsEmail = notificationsEmail;
		this.notificationsPush = notificationsPush;
		this.notificationsMarketing = notificationsMarketing;
		this.notificationsSecurity = notificationsSecurity;
		this.twoFactorEnabled = twoFactorEnabled;
		this.skills = skills;
		this.currentPassword = currentPassword;
		this.newPassword = newPassword;
		this.profilePicture = profilePicture;
		this.profilePictureType = profilePictureType;
		this.department = department;
		this.position = position;
		this.indicator = indicator;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getGithub() {
		return github;
	}

	public void setGithub(String github) {
		this.github = github;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public Boolean getNotificationsEmail() {
		return notificationsEmail;
	}

	public void setNotificationsEmail(Boolean notificationsEmail) {
		this.notificationsEmail = notificationsEmail;
	}

	public Boolean getNotificationsPush() {
		return notificationsPush;
	}

	public void setNotificationsPush(Boolean notificationsPush) {
		this.notificationsPush = notificationsPush;
	}

	public Boolean getNotificationsMarketing() {
		return notificationsMarketing;
	}

	public void setNotificationsMarketing(Boolean notificationsMarketing) {
		this.notificationsMarketing = notificationsMarketing;
	}

	public Boolean getNotificationsSecurity() {
		return notificationsSecurity;
	}

	public void setNotificationsSecurity(Boolean notificationsSecurity) {
		this.notificationsSecurity = notificationsSecurity;
	}

	public Boolean getTwoFactorEnabled() {
		return twoFactorEnabled;
	}

	public void setTwoFactorEnabled(Boolean twoFactorEnabled) {
		this.twoFactorEnabled = twoFactorEnabled;
	}

	public List<SkillAddRequest> getSkills() {
		return skills;
	}

	public void setSkills(List<SkillAddRequest> skills) {
		this.skills = skills;
	}

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getIndicator() {
		return indicator;
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	@Override
	public String toString() {
		return "ProfileUpdateRequest [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", title=" + title + ", company=" + company + ", location=" + location + ", bio=" + bio
				+ ", education=" + education + ", website=" + website + ", github=" + github + ", linkedin=" + linkedin
				+ ", status=" + status + ", role=" + role + ", roleType=" + roleType + ", notificationsEmail="
				+ notificationsEmail + ", notificationsPush=" + notificationsPush + ", notificationsMarketing="
				+ notificationsMarketing + ", notificationsSecurity=" + notificationsSecurity + ", twoFactorEnabled="
				+ twoFactorEnabled + ", skills=" + skills + ", currentPassword=" + currentPassword + ", newPassword="
				+ newPassword + ", profilePicture=" + profilePicture + ", profilePictureType=" + profilePictureType
				+ ", department=" + department + ", position=" + position + ", indicator=" + indicator + "]";
	}

}
