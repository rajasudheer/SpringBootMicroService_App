package com.telstra.exceptions;

public class ErrorResponse {
    int errorCode;
    String message;
   
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

   

}
