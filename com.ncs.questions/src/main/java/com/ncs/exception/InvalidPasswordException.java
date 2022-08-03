package com.ncs.exception;

public class InvalidPasswordException extends Exception {

	private String errorMessage;
	private String password;
	private int userInput;

	public InvalidPasswordException() {
		super();
	}

	public InvalidPasswordException(String errorMessage, String password, int userInput) {
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
