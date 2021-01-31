package com.api.domain.exception;

public class ApiEntityNotFoundException extends ApiException {
	private static final long serialVersionUID = 7014034895053162949L;
	
	public ApiEntityNotFoundException() {
		super();
	}

	public ApiEntityNotFoundException(String message) {
		super(message);
	}
	
	public ApiEntityNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
