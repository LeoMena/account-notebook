package com.lmena.notebook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidTransactionIdException extends RuntimeException {

	private static final long serialVersionUID = -419658998785145548L;

	public InvalidTransactionIdException(String message) {
		super(message);
	}
}
