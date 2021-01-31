package com.api.domain.exception;

public class EntityNotFoundException extends ApiException {
	private static final long serialVersionUID = 7014034895053162949L;
	
	public EntityNotFoundException() {
		super();
	}

	public EntityNotFoundException(String message) {
		super(message);
	}
	
	public EntityNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
