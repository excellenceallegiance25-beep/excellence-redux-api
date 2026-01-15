package com.eapl.excellence.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eapl.excellence.repo.LeaveManagementRepo;
import com.eapl.excellence.request.EmpLeaveRequest;
import com.eapl.excellence.response.CommonResponse;
import com.eapl.excellence.response.LeaveResponse;

@Service
public class LeaveMngmtService implements ILeaveMngmtService {

	private final LeaveManagementRepo leaveManagementRepo;

	@Autowired
	public LeaveMngmtService(LeaveManagementRepo leaveManagementRepo) {
		this.leaveManagementRepo = leaveManagementRepo;
	}

	@Override
	public CommonResponse EmpLeaveRequestDetails(EmpLeaveRequest request) {
		try {
			List<CommonResponse> responses = leaveManagementRepo.updateLeaveRequestDetails(request);

			if (responses != null && !responses.isEmpty()) {
				// Return the first response (should be only one)
				return responses.get(0);
			} else {
				return new CommonResponse(false, "No response from database", "error", null);
			}
		} catch (Exception e) {
			return new CommonResponse(false, "Error: " + e.getMessage(), "error", null);
		}
	}

	@Override
	public CommonResponse EmpLeaveDetails() {
		try {
			List<LeaveResponse> responses = leaveManagementRepo.getAllEmpLeaveDetails();

			if (responses != null && !responses.isEmpty()) {
				// Return ALL responses, not just the first one
				return new CommonResponse(true, "Leave details retrieved successfully", "success", responses);
			} else {
				// Empty list when no data found
				return new CommonResponse(true, "No leave requests found", "success", new ArrayList<>());
			}
		} catch (Exception e) {
			e.printStackTrace(); // Log the error
			return new CommonResponse(false, "Error retrieving leave details: " + e.getMessage(), "error", null);
		}
	}
}