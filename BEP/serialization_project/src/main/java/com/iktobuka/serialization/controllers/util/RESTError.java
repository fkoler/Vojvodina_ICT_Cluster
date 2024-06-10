package com.iktobuka.serialization.controllers.util;

import com.fasterxml.jackson.annotation.JsonView;
import com.iktobuka.serialization.security.Views;

public class RESTError {

	@JsonView(Views.Public.class)
	protected Integer code;

	@JsonView(Views.Public.class)
	protected String message;

	public RESTError(Integer code, String message) {
		super();
		this.setCode(code);
		this.setMessage(message);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
