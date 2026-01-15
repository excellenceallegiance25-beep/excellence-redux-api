package com.eapl.excellence.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.eapl.excellence.exception.EaplException;
import com.eapl.excellence.mailConfig.EmailSender;
import com.eapl.excellence.repo.UserRepo;
import com.eapl.excellence.request.PartnerDetailRequest;
import com.eapl.excellence.response.AchievementResponse;
import com.eapl.excellence.response.CommonResponse;
import com.eapl.excellence.response.EmployeeProfileResponse;
import com.eapl.excellence.response.EmployeeResponse;
import com.eapl.excellence.response.JobOpeningResponse;
import com.eapl.excellence.response.PartnerResponse;
import com.eapl.excellence.response.UserReviewResponse;
import com.eapl.excellence.utilities.Constant;
import com.eapl.excellence.utilities.Utility;

@Service
public class UserServices implements IUserServices {

	private final UserRepo userRepo;
	private final Utility utility;
	private final EmailSender emailSender;

	@Autowired
	public UserServices(UserRepo userRepo, Utility utility, EmailSender emailSender) {
		this.userRepo = userRepo;
		this.utility = utility;
		this.emailSender = emailSender;
	}

	@Override
	public List<UserReviewResponse> getReviewDetails() {
		return userRepo.getAllReviewDetails();
	}

	@Override
	public List<JobOpeningResponse> getOpenings() {
		return userRepo.getAllOpenings();
	}

	@Override
	public List<PartnerResponse> getAllPartners() {
		return userRepo.getAllPartnerDetails();
	}

	@Override
	public List<AchievementResponse> getAchievements() {
		return userRepo.getAllAchievements();
	}

	@Override
	public List<EmployeeResponse> getAllEmployees() {
		return userRepo.getAllEmployees();
	}

//	@Override
//	public CommonResponse getAllEmployees() {
//
//		List<EmployeeResponse> employeeList;
//
//		try {
//			employeeList = userRepo.getAllEmployees();
//		} catch (Exception e) {
//			throw new EaplException("Exception from getAllEmployees", e.getMessage());
//		}
//
//		return new CommonResponse(true, "Employees fetched successfully", "EMPLOYEE_LIST", employeeList);
//	}

	@Override
	public List<EmployeeProfileResponse> loginUser(String email, String password) {
		List<EmployeeProfileResponse> dbresponse = null;
		try {
			dbresponse = userRepo.getUserDetails(email, password);
		} catch (Exception e) {
			throw new EaplException("exception from loginUser -->", utility.printJson(dbresponse));
		}
		return dbresponse;
	}

	@Override
	public CommonResponse forgotPasswordOTPDetails(String email) {
		try {
			// 1. Generate OTP
			String otp = utility.generateOTP();

			// 2. DB call
			List<CommonResponse> dbResponse = userRepo.forgotPasswordOTPDetails(email, otp);

			CommonResponse response = dbResponse.get(0);

			// 3. Send mail if success
			if (response.getSuccess()) {

				Map<String, String> replacers = new HashMap<>();
				replacers.put("{{OTP}}", otp);
				replacers.put("{{EMAIL}}", email);

				emailSender.sendMail(new String[] { email }, // TO
						null, // CC
						null, // BCC
						"Password Reset OTP", // Subject
						replacers, "mail-templates/password-reset-otp.html");
			}

			return new CommonResponse(response.getSuccess(), response.getMessage(), "OTP_SENT",
					Collections.singletonList(otp));

		} catch (Exception e) {
			throw new EaplException(Constant.DATABASE_ERROR_MSG, Constant.DATABASE_ERROR_CODE, e);
		}
	}

	@Override
	public CommonResponse resetPasswordDetails(String email, String newPassword) {
		try {
			List<CommonResponse> dbResponse = userRepo.resetPasswordDetails(email, newPassword);

			CommonResponse response = dbResponse.get(0);

			return new CommonResponse(response.getSuccess(), response.getMessage(), "PASSWORD_RESET", null);

		} catch (Exception e) {
			throw new EaplException("Exception from resetPasswordDetails", utility.printJson(email), e);
		}
	}

	@Override
	public CommonResponse updatePartnersDetails(PartnerDetailRequest request) {
		try {
			// Validate request based on operation
			String operation = request.getIndicator();

			if (operation == null || operation.trim().isEmpty()) {
				return new CommonResponse(false, "Operation indicator is required", "error", null);
			}

			// Convert to uppercase for consistency
			operation = operation.toUpperCase();

			// Validate for Update/Delete operations
			if (operation.equals("U") || operation.equals("D")) {
				if (request.getId() == 0) {
					return new CommonResponse(false, "Service ID is required for update/delete", "error", null);
				}
			}

			// Validate for Insert operation
			if (operation.equals("I")) {
				if (request.getName() == null || request.getName().trim().isEmpty()) {
					return new CommonResponse(false, "Service title is required", "error", null);
				}
			}

			// Call repository
			List<CommonResponse> responses = userRepo.updatePartnerRequestDetails(request);

			if (responses != null && !responses.isEmpty()) {
				return responses.get(0);
			} else {
				return new CommonResponse(false, "No response from database", "error", null);
			}
		} catch (Exception e) {
			return new CommonResponse(false, "Error: " + e.getMessage(), "error", null);
		}
	}

}
