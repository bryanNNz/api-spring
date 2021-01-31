package com.api.domain.exception;

public class ApiException extends RuntimeException {
	private static final long serialVersionUID = 8965158489805826139L;
	
	public ApiException() {
		super();
	}

	public ApiException(String message) {
		super(message);
	}
	
	public ApiException(String message, Throwable cause) {
		super(message, cause);
	}
}
