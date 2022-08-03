package com.ncs.exception;

import java.sql.Timestamp;

public class ExceptionTemplate {

	private String msg;
	private int userInput;
	private Timestamp dateTime;

	public ExceptionTemplate() {
		super();
	}

	public ExceptionTemplate(String msg, int userInput, Timestamp dateTime) {
		super();
		this.msg = msg;
		this.userInput = userInput;
		this.dateTime = dateTime;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getUserInput() {
		return userInput;
	}

	public void setUserInput(int userInput) {
		this.userInput = userInput;
	}

	public Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "ExceptionTemplate [msg=" + msg + ", userInput=" + userInput + ", dateTime=" + dateTime + "]";
	}

}
