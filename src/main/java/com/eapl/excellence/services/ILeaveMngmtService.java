package com.eapl.excellence.services;

import com.eapl.excellence.request.EmpLeaveRequest;
import com.eapl.excellence.response.CommonResponse;

public interface ILeaveMngmtService {

	CommonResponse EmpLeaveRequestDetails(EmpLeaveRequest request);

	CommonResponse EmpLeaveDetails();

}
