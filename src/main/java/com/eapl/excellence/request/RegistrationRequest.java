// SimpleProfileUpdateRequest.java
package com.eapl.excellence.request;

import java.util.List;
import java.util.Map;

public class RegistrationRequest {

	private Integer employeeId;
	// Profile fields (optional - only send what changed)
	private String firstname;
	private String lastname;
	private String email;
	private String company;
	private String phone;

	// Password change (optional)
	private String currentPassword;
	private String newPassword;

	public RegistrationRequest() {
	}

	public RegistrationRequest(Integer employeeId, String firstname, String lastname, String email, String company,
			String phone, String currentPassword, String newPassword) {
		super();
		this.employeeId = employeeId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.company = company;
		this.phone = phone;
		this.currentPassword = currentPassword;
		this.newPassword = newPassword;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	@Override
	public String toString() {
		return "RegistrationRequest [employeeId=" + employeeId + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", company=" + company + ", phone=" + phone + ", currentPassword="
				+ currentPassword + ", newPassword=" + newPassword + "]";
	}

}