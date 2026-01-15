package com.eapl.excellence.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eapl.excellence.exception.EaplException;
import com.eapl.excellence.repo.ProfileRepo;
import com.eapl.excellence.request.ProfileUpdateRequest;
import com.eapl.excellence.request.RegistrationRequest;
import com.eapl.excellence.response.CommonResponse;
import com.eapl.excellence.response.EmployeeHistoryResponse;
import com.eapl.excellence.response.EmployeeProfileResponse;
import com.eapl.excellence.response.EmployeeSkillResponse;
import com.eapl.excellence.utilities.Constant;
import com.eapl.excellence.utilities.Utility;

@Service
public class ProfileServices implements IProfileServices {

	private final ProfileRepo profileRepo;
	private final Utility utility;

	@Autowired
	public ProfileServices(ProfileRepo profileRepo, Utility utility) {
		this.profileRepo = profileRepo;
		this.utility = utility;
	}

	@Override
	public List<EmployeeProfileResponse> getEmployeeDetails() {
		try {
			return profileRepo.getAllProfiles();
		} catch (Exception e) {
			throw new EaplException(Constant.DATABASE_ERROR_MSG, Constant.DATABASE_ERROR_CODE, e);
		}
	}

	@Override
	public List<EmployeeSkillResponse> getAllSkills() {
		return profileRepo
				.getAllSkills().stream().map(s -> new EmployeeSkillResponse(s.getId(), s.getEmployeeId(),
						s.getSkillName(), s.getLevel(), s.getYearsExperience(), s.getUpdatedAt()))
				.collect(Collectors.toList());
	}

	@Override
	public List<EmployeeHistoryResponse> getAllHistory() {
		return profileRepo.getAllHistory().stream().map(h -> new EmployeeHistoryResponse(h.getId(), h.getEmployeeId(),
				h.getFieldName(), h.getAction(), h.getTimestamp(), h.getStatus())).collect(Collectors.toList());
	}

	@Override
	public Map<String, Object> updateCompleteProfile(ProfileUpdateRequest request) {
		// TODO Auto-generated method stub
		return profileRepo.updateCompleteProfile(request);
	}

	@Override
	public CommonResponse addNewUser(RegistrationRequest request) {
		try {
			List<CommonResponse> dbResponse = profileRepo.addNewUserDetails(request);
			return new CommonResponse(dbResponse.get(0).getSuccess(), dbResponse.get(0).getMessage(), null, dbResponse);

		} catch (Exception e) {
			throw new EaplException(Constant.DATABASE_ERROR_MSG, Constant.DATABASE_ERROR_CODE, e);
		}
	}

}
