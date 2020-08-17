package com.example.demo.rest.exception;

public class RestErrorDto {

	private final String errorCode;
	private final String message;

	public String getMessage() {
		return message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public RestErrorDto(String errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}
}
