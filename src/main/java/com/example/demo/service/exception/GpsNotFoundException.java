package com.example.demo.service.exception;

public class GpsNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -5752418844362266204L;

	private static final String NOT_FOUND_GPS = "NOT_FOUND_GPS";
	private final String errorCode;

	public GpsNotFoundException(String message) {
		super(message);
		errorCode = NOT_FOUND_GPS;
	}

	public String getErrorCode() {
		return errorCode;
	}
}
