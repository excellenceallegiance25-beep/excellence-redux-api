package com.eapl.excellence.request;

import java.util.List;
import java.util.Map;

public class CompleteProfileUpdateRequest {

	private String actionType;
	private Integer employeeId;
	private Map<String, Object> profileUpdates;
	private SkillsUpdateRequest skills;
	private List<HistoryEntryRequest> historyEntries;
	private PasswordChangeRequest passwordChange;
	private String timestamp;

	CompleteProfileUpdateRequest() {
	}

	public CompleteProfileUpdateRequest(String actionType, Integer employeeId, Map<String, Object> profileUpdates,
			SkillsUpdateRequest skills, List<HistoryEntryRequest> historyEntries, PasswordChangeRequest passwordChange,
			String timestamp) {
		super();
		this.actionType = actionType;
		this.employeeId = employeeId;
		this.profileUpdates = profileUpdates;
		this.skills = skills;
		this.historyEntries = historyEntries;
		this.passwordChange = passwordChange;
		this.timestamp = timestamp;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Map<String, Object> getProfileUpdates() {
		return profileUpdates;
	}

	public void setProfileUpdates(Map<String, Object> profileUpdates) {
		this.profileUpdates = profileUpdates;
	}

	public SkillsUpdateRequest getSkills() {
		return skills;
	}

	public void setSkills(SkillsUpdateRequest skills) {
		this.skills = skills;
	}

	public List<HistoryEntryRequest> getHistoryEntries() {
		return historyEntries;
	}

	public void setHistoryEntries(List<HistoryEntryRequest> historyEntries) {
		this.historyEntries = historyEntries;
	}

	public PasswordChangeRequest getPasswordChange() {
		return passwordChange;
	}

	public void setPasswordChange(PasswordChangeRequest passwordChange) {
		this.passwordChange = passwordChange;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "CompleteProfileUpdateRequest [actionType=" + actionType + ", employeeId=" + employeeId
				+ ", profileUpdates=" + profileUpdates + ", skills=" + skills + ", historyEntries=" + historyEntries
				+ ", passwordChange=" + passwordChange + ", timestamp=" + timestamp + "]";
	}

}
