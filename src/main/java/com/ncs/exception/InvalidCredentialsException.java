package com.ncs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidCredentialsException extends RuntimeException {
	private String errorMessage;
	private String password;
	private int userInput;

	public InvalidCredentialsException() {
		super();
	}

	public InvalidCredentialsException(String errorMessage, String password, int userInput) {
		super();
		this.errorMessage = errorMessage;
		this.password = password;
		this.userInput = userInput;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserInput() {
		return userInput;
	}

	public void setUserInput(int userInput) {
		this.userInput = userInput;
	}

	@Override
	public String toString() {
		return password + " is invalid";
	}
}
