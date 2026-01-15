package com.eapl.excellence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eapl.excellence.request.ServicesDetailRequest;
import com.eapl.excellence.response.CommonDetailResponse;
import com.eapl.excellence.response.CommonResponse;
import com.eapl.excellence.response.ServiceResponse;
import com.eapl.excellence.services.IServiceDataService;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

	private final IServiceDataService serviceDataService;

	@Autowired
	public ServiceController(IServiceDataService serviceDataService) {
		this.serviceDataService = serviceDataService;
	}

	@GetMapping(value = "", produces = "application/json")
	public List<ServiceResponse> getAllServices() {
		return serviceDataService.getServices();
	}

	@GetMapping(value = "/roles", produces = "application/json")
	public List<CommonDetailResponse> getAllRole() {
		return serviceDataService.getAllRoleDetails();
	}

	@GetMapping(value = "/departments", produces = "application/json")
	public List<CommonDetailResponse> getAllDepartment() {
		return serviceDataService.getAllDepartmentDetails();
	}

	@GetMapping(value = "/positions", produces = "application/json")
	public List<CommonDetailResponse> getAllPositions() {
		return serviceDataService.getAllPositionDetails();
	}

	@PostMapping(value = "/updateServiceDetails", consumes = "application/json", produces = "application/json")
	public ResponseEntity<CommonResponse> UpdateServiceDetails(@RequestBody ServicesDetailRequest request) {

		CommonResponse response = serviceDataService.updateServiceDetails(request);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
