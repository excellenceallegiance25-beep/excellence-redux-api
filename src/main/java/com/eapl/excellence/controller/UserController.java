package com.eapl.excellence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eapl.excellence.request.PartnerDetailRequest;
import com.eapl.excellence.response.AchievementResponse;
import com.eapl.excellence.response.CommonResponse;
import com.eapl.excellence.response.EmployeeProfileResponse;
import com.eapl.excellence.response.EmployeeResponse;
import com.eapl.excellence.response.JobOpeningResponse;
import com.eapl.excellence.response.PartnerResponse;
import com.eapl.excellence.response.UserReviewResponse;
import com.eapl.excellence.services.IUserServices;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final IUserServices userServices;

	@Autowired
	public UserController(IUserServices userServices) {
		this.userServices = userServices;
	}

	@PostMapping(value = "/login", produces = "application/json")
	public CommonResponse loginUserEmailandPass(@RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password) {

		List<EmployeeProfileResponse> dbresponse = userServices.loginUser(email, password);

		return new CommonResponse(true, "sucessfully fetched user details", "login", dbresponse);
	}

	@PostMapping(value = "/forgotPasswordSendEmail", produces = "application/json")
	public ResponseEntity<CommonResponse> forgotPasswordOTP(@RequestParam(name = "email") String email) {

		CommonResponse response = userServices.forgotPasswordOTPDetails(email);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/resetPassword", produces = "application/json")
	public ResponseEntity<CommonResponse> resetPassword(@RequestParam(name = "email") String email,
			@RequestParam(name = "newPassword") String newPassword) {

		CommonResponse response = userServices.resetPasswordDetails(email, newPassword);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/reviews")
	public List<UserReviewResponse> getAllReviews() {
		return userServices.getReviewDetails();
	}

	@GetMapping("/partners")
	public List<PartnerResponse> getPartners() {
		return userServices.getAllPartners();
	}

	@GetMapping("/jobopening")
	public List<JobOpeningResponse> getJobOpenings() {
		return userServices.getOpenings();
	}

	@GetMapping("/achievements")
	public List<AchievementResponse> getAchievements() {
		return userServices.getAchievements();
	}

	@GetMapping("/employees")
	public List<EmployeeResponse> getEmployees() {
		return userServices.getAllEmployees();
	}

	@PostMapping(value = "/updatePartnersDetails", consumes = "application/json", produces = "application/json")
	public ResponseEntity<CommonResponse> UpdateServiceDetails(@RequestBody PartnerDetailRequest request) {

		CommonResponse response = userServices.updatePartnersDetails(request);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
