package com.api.domain.exception;

public class ApiConstraintViolationException extends ApiException {
	private static final long serialVersionUID = 521955130730502419L;
	
	public ApiConstraintViolationException() {
		super();
	}

	public ApiConstraintViolationException(String message) {
		super(message);
	}
	
	public ApiConstraintViolationException(String message, Throwable cause) {
		super(message, cause);
	}
}
