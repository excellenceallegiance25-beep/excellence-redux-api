package com.eapl.excellence.services;

import java.util.List;

import com.eapl.excellence.request.EmpLeaveRequest;
import com.eapl.excellence.request.ServicesDetailRequest;
import com.eapl.excellence.response.CommonDetailResponse;
import com.eapl.excellence.response.CommonResponse;
import com.eapl.excellence.response.ServiceResponse;

public interface IServiceDataService {
	List<ServiceResponse> getServices();

	List<CommonDetailResponse> getAllRoleDetails();

	List<CommonDetailResponse> getAllDepartmentDetails();

	List<CommonDetailResponse> getAllPositionDetails();

	CommonResponse updateServiceDetails(ServicesDetailRequest request);
}
