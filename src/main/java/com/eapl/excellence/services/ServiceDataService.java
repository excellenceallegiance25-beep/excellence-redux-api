package com.eapl.excellence.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eapl.excellence.repo.ServiceRepo;
import com.eapl.excellence.request.EmpLeaveRequest;
import com.eapl.excellence.request.ServicesDetailRequest;
import com.eapl.excellence.response.CommonDetailResponse;
import com.eapl.excellence.response.CommonResponse;
import com.eapl.excellence.response.ServiceResponse;

@Service
public class ServiceDataService implements IServiceDataService {

	private final ServiceRepo serviceRepo;

	@Autowired
	public ServiceDataService(ServiceRepo serviceRepo) {
		this.serviceRepo = serviceRepo;
	}

	@Override
	public List<ServiceResponse> getServices() {
		return serviceRepo.getAllServices();
	}

	@Override
	public List<CommonDetailResponse> getAllRoleDetails() {
		return serviceRepo.getAllRoleDetails();
	}

	@Override
	public List<CommonDetailResponse> getAllDepartmentDetails() {
		return serviceRepo.getAllDepartmentDetails();
	}

	@Override
	public List<CommonDetailResponse> getAllPositionDetails() {
		return serviceRepo.getAllPositionDetails();
	}

	@Override
	public CommonResponse updateServiceDetails(ServicesDetailRequest request) {
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
				if (request.getId() == null) {
					return new CommonResponse(false, "Service ID is required for update/delete", "error", null);
				}
			}

			// Validate for Insert operation
			if (operation.equals("I")) {
				if (request.getTitle() == null || request.getTitle().trim().isEmpty()) {
					return new CommonResponse(false, "Service title is required", "error", null);
				}
			}

			// Call repository
			List<CommonResponse> responses = serviceRepo.updateServiceRequestDetails(request);

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
