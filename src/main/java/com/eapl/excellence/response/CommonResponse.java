package com.eapl.excellence.response;

import java.util.List;

public class CommonResponse {

	private Boolean success;
	private String message;
	private String type;
	private List<?> dataList;

	public CommonResponse() {
	}

	public CommonResponse(Boolean success, String message, String type, List<?> dataList) {
		super();
		this.success = success;
		this.message = message;
		this.type = type;
		this.dataList = dataList;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<?> getDataList() {
		return dataList;
	}

	public void setDataList(List<?> dataList) {
		this.dataList = dataList;
	}

	@Override
	public String toString() {
		return "CommonResponse [success=" + success + ", message=" + message + ", type=" + type + ", dataList="
				+ dataList + "]";
	}

}
