package com.eapl.excellence.response;

public class LeaveResponse {
	private String leaveId;
	private String employeeId;
	private String employeeName;
	private String leaveType;
	private String startDate;
	private String endDate;
	private String reason;
	private String status;
	private String isHalfDay;
	private String halfDayPeriod;
	private String totalDays;
	private String appliedDate;
	private String updatedAt;
	private String approvedBy;
	private String approvedDate;
	private String rejectionReason;

	public LeaveResponse() {
	}

	public LeaveResponse(String leaveId, String employeeId, String employeeName, String leaveType, String startDate,
			String endDate, String reason, String status, String isHalfDay, String halfDayPeriod, String totalDays,
			String appliedDate, String updatedAt, String approvedBy, String approvedDate, String rejectionReason) {
		super();
		this.leaveId = leaveId;
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.leaveType = leaveType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
		this.status = status;
		this.isHalfDay = isHalfDay;
		this.halfDayPeriod = halfDayPeriod;
		this.totalDays = totalDays;
		this.appliedDate = appliedDate;
		this.updatedAt = updatedAt;
		this.approvedBy = approvedBy;
		this.approvedDate = approvedDate;
		this.rejectionReason = rejectionReason;
	}

	public String getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(String leaveId) {
		this.leaveId = leaveId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsHalfDay() {
		return isHalfDay;
	}

	public void setIsHalfDay(String isHalfDay) {
		this.isHalfDay = isHalfDay;
	}

	public String getHalfDayPeriod() {
		return halfDayPeriod;
	}

	public void setHalfDayPeriod(String halfDayPeriod) {
		this.halfDayPeriod = halfDayPeriod;
	}

	public String getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(String totalDays) {
		this.totalDays = totalDays;
	}

	public String getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(String appliedDate) {
		this.appliedDate = appliedDate;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(String approvedDate) {
		this.approvedDate = approvedDate;
	}

	public String getRejectionReason() {
		return rejectionReason;
	}

	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}

	@Override
	public String toString() {
		return "LeaveResponse [leaveId=" + leaveId + ", employeeId=" + employeeId + ", employeeName=" + employeeName
				+ ", leaveType=" + leaveType + ", startDate=" + startDate + ", endDate=" + endDate + ", reason="
				+ reason + ", status=" + status + ", isHalfDay=" + isHalfDay + ", halfDayPeriod=" + halfDayPeriod
				+ ", totalDays=" + totalDays + ", appliedDate=" + appliedDate + ", updatedAt=" + updatedAt
				+ ", approvedBy=" + approvedBy + ", approvedDate=" + approvedDate + ", rejectionReason="
				+ rejectionReason + "]";
	}

}
