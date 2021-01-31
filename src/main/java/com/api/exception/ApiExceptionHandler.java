package com.api.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.api.domain.builder.ErrorObjectBuilder;
import com.api.domain.exception.ApiConstraintViolationException;
import com.api.domain.exception.ApiEntityNotFoundException;
import com.api.domain.model.ErrorObject;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	private final static String PROBLEM_CONTENT_TYPE = "application/problem+json";
	
	@ExceptionHandler(ApiEntityNotFoundException.class)
	public ResponseEntity<ErrorObject> entityNotFound(ApiEntityNotFoundException ex, HttpServletRequest req) {
		ErrorObject err = ErrorObjectBuilder.builder()
				.type("about:blank")
				.title("Entity not found")
				.status(HttpStatus.NOT_FOUND.value())
				.detail(ex.getMessage())
				.instance(req.getRequestURI())
				.get();
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.contentType(MediaType.valueOf(PROBLEM_CONTENT_TYPE))
				.body(err);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorObject> invalidArgument(IllegalArgumentException ex, HttpServletRequest req) {
		ErrorObject err = ErrorObjectBuilder.builder()
				.type("about:blank")
				.title("Invalid Argument")
				.status(HttpStatus.BAD_REQUEST.value())
				.detail(ex.getMessage())
				.instance(req.getRequestURI())
				.get();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.contentType(MediaType.valueOf(PROBLEM_CONTENT_TYPE))
				.body(err);
	}
	
	@ExceptionHandler(ApiConstraintViolationException.class)
	public ResponseEntity<ErrorObject> constraintViolation(ApiConstraintViolationException ex, HttpServletRequest req) {
		ErrorObject err = ErrorObjectBuilder.builder()
				.type("about:blank")
				.title("Contraint Violation")
				.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.detail(ex.getMessage())
				.instance(req.getRequestURI())
				.get();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.contentType(MediaType.valueOf(PROBLEM_CONTENT_TYPE))
				.body(err);
	}
}
