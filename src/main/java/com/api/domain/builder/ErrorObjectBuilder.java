package com.api.domain.builder;

import com.api.domain.model.ErrorObject;

public class ErrorObjectBuilder {
	private ErrorObject error;
	
	private ErrorObjectBuilder() {
		error = new ErrorObject();
	}
	
	public static ErrorObjectBuilder builder() {
		return new ErrorObjectBuilder();
	}
	
	
	public ErrorObjectBuilder type(String type) {
		this.error.setType(type);
		return this;
	}
	
	public ErrorObjectBuilder title(String title) {
		this.error.setTitle(title);
		return this;
	}
	
	
	public ErrorObjectBuilder detail(String detail) {
		this.error.setDetail(detail);
		return this;
	}
	
	public ErrorObjectBuilder instance(String instance) {
		this.error.setInstance(instance);
		return this;
	}
	
	public ErrorObject get() {
		return this.error;
	}
}
