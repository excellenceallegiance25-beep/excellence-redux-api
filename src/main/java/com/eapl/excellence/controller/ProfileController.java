package com.eapl.excellence.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eapl.excellence.request.ProfileUpdateRequest;
import com.eapl.excellence.request.RegistrationRequest;
import com.eapl.excellence.response.CommonResponse;
import com.eapl.excellence.response.EmployeeHistoryResponse;
import com.eapl.excellence.response.EmployeeProfileResponse;
import com.eapl.excellence.response.EmployeeSkillResponse;
import com.eapl.excellence.services.IProfileServices;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

	private final IProfileServices profileServices;

	@Autowired
	public ProfileController(IProfileServices profileServices) {
		this.profileServices = profileServices;
	}

	@GetMapping(value = "/employeeinfo", produces = "application/json")
	public ResponseEntity<List<EmployeeProfileResponse>> getAllEmployeeDetails() {
		List<EmployeeProfileResponse> response = profileServices.getEmployeeDetails();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/skills", produces = "application/json")
	public ResponseEntity<List<EmployeeSkillResponse>> getSkills() {
		return ResponseEntity.ok(profileServices.getAllSkills());
	}

	@GetMapping(value = "/history", produces = "application/json")
	public ResponseEntity<List<EmployeeHistoryResponse>> getHistory() {
		return ResponseEntity.ok(profileServices.getAllHistory());
	}

	@PostMapping(value = "/update", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Map<String, Object>> updateCompleteProfile(
			@RequestBody(required = false) ProfileUpdateRequest request) {
		Map<String, Object> result = profileServices.updateCompleteProfile(request);
		return ResponseEntity.ok(result);
	}

	@PostMapping(value = "/newRegistration", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CommonResponse> registerNewUser(@RequestBody RegistrationRequest request) {

		CommonResponse response = profileServices.addNewUser(request);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
