package com.ncs.exception;

public class InvalidRoleException extends Exception {

	private String errorMsg;
	private String role;
	private int userInput;

	public InvalidRoleException() {
		super();
	}

	public InvalidRoleException(String errorMsg, String role, int userInput) {
		super();
		this.errorMsg = errorMsg;
		this.role = role;
		this.userInput = userInput;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getUserInput() {
		return userInput;
	}

	public void setUserInput(int userInput) {
		this.userInput = userInput;
	}

	@Override
	public String toString() {
		return role + " is invalid";
	}

}
