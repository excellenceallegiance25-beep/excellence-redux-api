package com.eapl.excellence.services;

import java.util.List;

import com.eapl.excellence.request.PartnerDetailRequest;
import com.eapl.excellence.response.AchievementResponse;
import com.eapl.excellence.response.CommonResponse;
import com.eapl.excellence.response.EmployeeProfileResponse;
import com.eapl.excellence.response.EmployeeResponse;
import com.eapl.excellence.response.JobOpeningResponse;
import com.eapl.excellence.response.PartnerResponse;
import com.eapl.excellence.response.UserReviewResponse;

public interface IUserServices {
	List<UserReviewResponse> getReviewDetails();

	List<JobOpeningResponse> getOpenings();

	List<PartnerResponse> getAllPartners();

	List<AchievementResponse> getAchievements();

	List<EmployeeResponse> getAllEmployees();

	List<EmployeeProfileResponse> loginUser(String email, String password);

	CommonResponse forgotPasswordOTPDetails(String email);

	CommonResponse resetPasswordDetails(String email, String newPassword);

	CommonResponse updatePartnersDetails(PartnerDetailRequest request);
}