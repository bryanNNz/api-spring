package com.api.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.api.domain.builder.ErrorObjectBuilder;
import com.api.domain.exception.EntityNotFoundException;
import com.api.domain.model.ErrorObject;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorObject> entityNotFound(EntityNotFoundException ex, HttpServletRequest req) {
		ErrorObject err = ErrorObjectBuilder.builder()
				.type("")
				.title("Entity not found")
				.detail(ex.getMessage())
				.instance(req.getRequestURI())
				.get();
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.contentType(MediaType.valueOf("application/problem+json"))
				.body(err);
	}
}
