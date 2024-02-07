package com.feb.lambdas.exceptions;

public class EmployeeValidationException extends Exception {

	private String errorCode;
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public EmployeeValidationException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

}
