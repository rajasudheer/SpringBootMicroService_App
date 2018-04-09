package com.telstra.exceptions;

public class InvalidInputValidationException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String errorMessage;
	private int errorCode;

	public String getErrorMessage() {
		return errorMessage;
	}

	public InvalidInputValidationException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public InvalidInputValidationException() {
		super();
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setMessage(String message) {
		this.errorMessage = message;
	}
}