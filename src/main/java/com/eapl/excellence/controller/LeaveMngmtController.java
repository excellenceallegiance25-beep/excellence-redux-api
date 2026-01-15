package com.eapl.excellence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eapl.excellence.request.EmpLeaveRequest;
import com.eapl.excellence.response.CommonResponse;
import com.eapl.excellence.services.ILeaveMngmtService;

@RestController
@RequestMapping("/api/leave")
public class LeaveMngmtController {

	private final ILeaveMngmtService leaveMngmtService;

	@Autowired
	public LeaveMngmtController(ILeaveMngmtService leaveMngmtService) {
		this.leaveMngmtService = leaveMngmtService;
	}

	@PostMapping(value = "/empLeaveRequest", consumes = "application/json", produces = "application/json")
	public ResponseEntity<CommonResponse> EmpLeaveRequestDetails(@RequestBody EmpLeaveRequest request) {

		CommonResponse response = leaveMngmtService.EmpLeaveRequestDetails(request);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/getEmpLeaveDetails", produces = "application/json")
	public ResponseEntity<CommonResponse> GetEmpLeaveDetails() {

		CommonResponse response = leaveMngmtService.EmpLeaveDetails();

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
