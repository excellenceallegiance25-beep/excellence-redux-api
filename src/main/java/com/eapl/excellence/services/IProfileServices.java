package com.eapl.excellence.services;

import java.util.List;
import java.util.Map;

import com.eapl.excellence.request.ProfileUpdateRequest;
import com.eapl.excellence.request.RegistrationRequest;
import com.eapl.excellence.response.CommonResponse;
import com.eapl.excellence.response.EmployeeHistoryResponse;
import com.eapl.excellence.response.EmployeeProfileResponse;
import com.eapl.excellence.response.EmployeeSkillResponse;

public interface IProfileServices {

	Map<String, Object> updateCompleteProfile(ProfileUpdateRequest request);

	List<EmployeeProfileResponse> getEmployeeDetails();

	List<EmployeeSkillResponse> getAllSkills();

	List<EmployeeHistoryResponse> getAllHistory();

	CommonResponse addNewUser(RegistrationRequest request);
}
