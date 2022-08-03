package com.ncs.exception;

public class InvalidCorrectAnswerException extends Exception {

	private String errorMsg;
	private String answer;
	private int userInput;

	public InvalidCorrectAnswerException() {
		super();
	}

	public InvalidCorrectAnswerException(String errorMsg, String answer, int userInput) {
		super();
		this.errorMsg = errorMsg;
		this.answer = answer;
		this.userInput = userInput;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getUserInput() {
		return userInput;
	}

	public void setUserInput(int userInput) {
		this.userInput = userInput;
	}

	@Override
	public String toString() {
		return answer + " does not exist in the question options";
	}

}
