package com.sena.adso2499719.adso2499719.dto;

public class ApiResponseDto<T> {
	
	public ApiResponseDto() {
		
	}
	
	public ApiResponseDto(String message, Boolean status, T data) {
		super();
		this.message = message;
		this.status = status;
		this.data = data;
	}

	private String message;
	
	private Boolean status;
	
	private T data;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}
