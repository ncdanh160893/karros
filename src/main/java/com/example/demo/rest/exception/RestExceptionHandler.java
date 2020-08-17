package com.example.demo.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.service.exception.GpsNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {

	private static final String INTERNAL_SERVER_ERROR_CODE = "INTERNAL_SERVER_ERROR";

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({ GpsNotFoundException.class })
	@ResponseBody
	public RestErrorDto handleUsernameNotFoundException(final GpsNotFoundException ex) {
		return new RestErrorDto(ex.getErrorCode(), ex.getMessage());
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({ Exception.class })
	@ResponseBody
	public RestErrorDto handleUnknownException(Exception ex) {
		return new RestErrorDto(INTERNAL_SERVER_ERROR_CODE, "Oops!. Internal server error.");
	}
}
