package com.foreign.frontend.common.exception;

import org.springframework.http.HttpStatus;

public class HttpCodeExceptiopn extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private HttpStatus status;

	public HttpCodeExceptiopn(HttpStatus status, String message) {
		super(message);
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
