package com.eapl.excellence.repo;

import com.eapl.excellence.request.EmpLeaveRequest;
import com.eapl.excellence.response.CommonResponse;
import com.eapl.excellence.response.LeaveResponse;
import com.eapl.excellence.utilities.Utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

@Repository
public class LeaveManagementRepo {

	private final NamedParameterJdbcTemplate jdbcTemplate;
	private final Utility utility;

	@Autowired
	public LeaveManagementRepo(NamedParameterJdbcTemplate jdbcTemplate, Utility utility) {
		this.jdbcTemplate = jdbcTemplate;
		this.utility = utility;
	}

	@Transactional
	public List<CommonResponse> updateLeaveRequestDetails(EmpLeaveRequest request) {
		String sql = "SELECT * FROM emp_update_leave_request("
				+ ":p_indicator, :p_leave_id, :p_employee_id, :p_employee_name, "
				+ ":p_leave_type, :p_start_date, :p_end_date, :p_reason, "
				+ ":p_status, :p_is_half_day, :p_half_day_period, :p_total_days, "
				+ ":p_performed_by, :p_rejection_reason)";

		Map<String, Object> params = new HashMap<>();

		// Format dates from dd-MM-yyyy to yyyy-MM-dd
		String formattedStartDate = utility.formatDate(request.getStartDate());
		String formattedEndDate = utility.formatDate(request.getEndDate());

		// Parse leave_id properly - handle string or integer
		Integer leaveId = utility.parseLeaveId(request.getLeaveId());

		// Parse total_days as DECIMAL
		Object totalDays = utility.parseTotalDays(request.getTotalDays());

		// Put all parameters with proper types
		params.put("p_indicator", request.getIndicator());
		params.put("p_leave_id", request.getLeaveId()); // Now properly as Integer
		params.put("p_employee_id", request.getEmployeeId());
		params.put("p_employee_name", request.getEmployeeName());
		params.put("p_leave_type", request.getLeaveType());
		params.put("p_start_date", request.getStartDate()); // Formatted date
		params.put("p_end_date", request.getEndDate()); // Formatted date
		params.put("p_reason", request.getReason());
		params.put("p_status", request.getStatus());
		params.put("p_is_half_day", request.getIsHalfDay());
		params.put("p_half_day_period", request.getHalfDayPeriod());
		params.put("p_total_days", request.getTotalDays()); // Proper DECIMAL type
		params.put("p_performed_by", request.getPerformedBy());
		params.put("p_rejection_reason", request.getRejectionReason());

		return jdbcTemplate.query(sql, params, (rs, rowNum) -> {
			Boolean success = rs.getBoolean("success");
			String message = rs.getString("messageText");
			String operation = rs.getString("operations");
			Integer leave_id = rs.getObject("leave_id", Integer.class);

			Map<String, Object> dataMap = new HashMap<>();
			dataMap.put("operations", operation);
			dataMap.put("leave_id", leave_id);

			List<Map<String, Object>> dataList = Collections.singletonList(dataMap);

			return new CommonResponse(success, message, "leave_operation", dataList);
		});
	}

	public List<LeaveResponse> getAllEmpLeaveDetails() {
		try {
			String sql = "SELECT * FROM fn_get_all_leave_requests()";

			return jdbcTemplate.query(sql, (rs, rowNum) -> {
				LeaveResponse response = new LeaveResponse();
				response.setLeaveId(rs.getString("leave_id"));
				response.setEmployeeId(rs.getString("employee_id"));
				response.setEmployeeName(rs.getString("employee_name"));
				response.setLeaveType(rs.getString("leave_type"));
				response.setStartDate(rs.getString("start_date"));
				response.setEndDate(rs.getString("end_date"));
				response.setReason(rs.getString("reason"));
				response.setStatus(rs.getString("status"));
				response.setIsHalfDay(rs.getString("is_half_day"));
				response.setHalfDayPeriod(rs.getString("half_day_period"));
				response.setTotalDays(rs.getString("total_days"));
				response.setAppliedDate(rs.getString("applied_date"));
				response.setUpdatedAt(rs.getString("updated_at"));
				response.setApprovedBy(rs.getString("approved_by"));
				response.setApprovedDate(rs.getString("approved_date"));
				response.setRejectionReason(rs.getString("rejection_reason"));
				return response;
			});
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Database error: " + e.getMessage());
		}
	}

}