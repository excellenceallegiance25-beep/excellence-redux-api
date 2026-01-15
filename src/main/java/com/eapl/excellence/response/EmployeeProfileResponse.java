package com.eapl.excellence.response;

public class EmployeeProfileResponse {

	private Integer id;

	// Basic Info
	private String name;
	private String email;
	private String phone;
	private String title;
	private String company;
	private String location;
	private String bio;

	// Education
	private String education;

	// Links
	private String website;
	private String github;
	private String linkedin;

	// Employment
	private String joinedDate;
	private boolean status;
	private String role;
	private String roleType;

	// Settings
	private Boolean notificationsEmail;
	private Boolean notificationsPush;
	private Boolean notificationsMarketing;
	private Boolean notificationsSecurity;
	private Boolean twoFactorEnabled;

	// Tracking
	private String lastProfileUpdate;
	private String createdAt;
	private String updatedAt;

	private String password;

	private String profilePicture; // base64 encoded image
	private String profilePictureType; // image/jpeg, image/png, etc.

	private String department;
	private String position;

	private String operationResult;
	private String operationMessage;

	public EmployeeProfileResponse() {
	}

	public EmployeeProfileResponse(Integer id, String name, String email, String phone, String title, String company,
			String location, String bio, String education, String website, String github, String linkedin,
			String joinedDate, boolean status, String role, String roleType, Boolean notificationsEmail,
			Boolean notificationsPush, Boolean notificationsMarketing, Boolean notificationsSecurity,
			Boolean twoFactorEnabled, String lastProfileUpdate, String createdAt, String updatedAt, String password,
			String profilePicture, String profilePictureType, String department, String position,
			String operationResult, String operationMessage) {
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
		this.joinedDate = joinedDate;
		this.status = status;
		this.role = role;
		this.roleType = roleType;
		this.notificationsEmail = notificationsEmail;
		this.notificationsPush = notificationsPush;
		this.notificationsMarketing = notificationsMarketing;
		this.notificationsSecurity = notificationsSecurity;
		this.twoFactorEnabled = twoFactorEnabled;
		this.lastProfileUpdate = lastProfileUpdate;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.password = password;
		this.profilePicture = profilePicture;
		this.profilePictureType = profilePictureType;
		this.department = department;
		this.position = position;
		this.operationResult = operationResult;
		this.operationMessage = operationMessage;
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

	public String getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(String joinedDate) {
		this.joinedDate = joinedDate;
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

	public String getLastProfileUpdate() {
		return lastProfileUpdate;
	}

	public void setLastProfileUpdate(String lastProfileUpdate) {
		this.lastProfileUpdate = lastProfileUpdate;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getOperationResult() {
		return operationResult;
	}

	public void setOperationResult(String operationResult) {
		this.operationResult = operationResult;
	}

	public String getOperationMessage() {
		return operationMessage;
	}

	public void setOperationMessage(String operationMessage) {
		this.operationMessage = operationMessage;
	}

	@Override
	public String toString() {
		return "EmployeeProfileResponse [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", title=" + title + ", company=" + company + ", location=" + location + ", bio=" + bio
				+ ", education=" + education + ", website=" + website + ", github=" + github + ", linkedin=" + linkedin
				+ ", joinedDate=" + joinedDate + ", status=" + status + ", role=" + role + ", roleType=" + roleType
				+ ", notificationsEmail=" + notificationsEmail + ", notificationsPush=" + notificationsPush
				+ ", notificationsMarketing=" + notificationsMarketing + ", notificationsSecurity="
				+ notificationsSecurity + ", twoFactorEnabled=" + twoFactorEnabled + ", lastProfileUpdate="
				+ lastProfileUpdate + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", password=" + password
				+ ", profilePicture=" + profilePicture + ", profilePictureType=" + profilePictureType + ", department="
				+ department + ", position=" + position + ", operationResult=" + operationResult + ", operationMessage="
				+ operationMessage + "]";
	}

}
