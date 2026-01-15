package com.eapl.excellence.request;

public class PasswordChangeRequest {

	private String currentPassword;
	private String newPassword;

	PasswordChangeRequest() {
	}

	public PasswordChangeRequest(String currentPassword, String newPassword) {
		super();
		this.currentPassword = currentPassword;
		this.newPassword = newPassword;
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
		return "PasswordChangeRequest [currentPassword=" + currentPassword + ", newPassword=" + newPassword + "]";
	}

}
