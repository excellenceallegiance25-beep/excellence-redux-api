package com.eapl.excellence.request;

public class HistoryEntryRequest {

	private Integer employeeId;
	private String fieldName;
	private String action;
	private String timestamp;
	private String status;

	HistoryEntryRequest() {
	}

	public HistoryEntryRequest(Integer employeeId, String fieldName, String action, String timestamp, String status) {
		super();
		this.employeeId = employeeId;
		this.fieldName = fieldName;
		this.action = action;
		this.timestamp = timestamp;
		this.status = status;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "HistoryEntryRequest [employeeId=" + employeeId + ", fieldName=" + fieldName + ", action=" + action
				+ ", timestamp=" + timestamp + ", status=" + status + "]";
	}

}
