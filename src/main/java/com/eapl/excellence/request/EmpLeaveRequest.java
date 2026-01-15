package com.eapl.excellence.request;

public class EmpLeaveRequest {

	private String indicator;
	private Integer leaveId;
	private Integer employeeId;
	private String employeeName;
	private String leaveType;
	private String startDate;
	private String endDate;
	private String reason;
	private String status;
	private Boolean isHalfDay;
	private String halfDayPeriod;
	private String totalDays;
	private String performedBy;
	private String rejectionReason;

	public EmpLeaveRequest() {
	}

	public EmpLeaveRequest(String indicator, Integer leaveId, Integer employeeId, String employeeName, String leaveType,
			String startDate, String endDate, String reason, String status, Boolean isHalfDay, String halfDayPeriod,
			String totalDays, String performedBy, String rejectionReason) {
		super();
		this.indicator = indicator;
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
		this.performedBy = performedBy;
		this.rejectionReason = rejectionReason;
	}

	public String getIndicator() {
		return indicator;
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	public Integer getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
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

	public Boolean getIsHalfDay() {
		return isHalfDay;
	}

	public void setIsHalfDay(Boolean isHalfDay) {
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

	public String getPerformedBy() {
		return performedBy;
	}

	public void setPerformedBy(String performedBy) {
		this.performedBy = performedBy;
	}

	public String getRejectionReason() {
		return rejectionReason;
	}

	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}

	@Override
	public String toString() {
		return "EmpLeaveRequest [indicator=" + indicator + ", leaveId=" + leaveId + ", employeeId=" + employeeId
				+ ", employeeName=" + employeeName + ", leaveType=" + leaveType + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", reason=" + reason + ", status=" + status + ", isHalfDay=" + isHalfDay
				+ ", halfDayPeriod=" + halfDayPeriod + ", totalDays=" + totalDays + ", performedBy=" + performedBy
				+ ", rejectionReason=" + rejectionReason + "]";
	}

}
