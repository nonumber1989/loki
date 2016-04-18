package org.sevenup.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -62028714630315197L;

	public ResourceNotFoundException() {
		this("Resource not found!");
	}

	public ResourceNotFoundException(String message) {
		this(message, null);
	}

	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
