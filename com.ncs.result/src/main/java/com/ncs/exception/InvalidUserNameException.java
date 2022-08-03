package com.ncs.exception;

public class InvalidUserNameException extends Exception {

	private String errorMessage;
	private String username;
	private int userInput;

	public InvalidUserNameException() {
		super();
	}

	public InvalidUserNameException(String errorMessage, String username, int userInput) {
		super();
		this.errorMessage = errorMessage;
		this.username = username;
		this.userInput = userInput;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getUserInput() {
		return userInput;
	}

	public void setUserInput(int userInput) {
		this.userInput = userInput;
	}

	@Override
	public String toString() {
		return username + " is invalid ";
	}

}
