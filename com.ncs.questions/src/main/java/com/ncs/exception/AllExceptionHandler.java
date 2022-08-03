package com.ncs.exception;

import java.sql.Timestamp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AllExceptionHandler {

	public AllExceptionHandler() {

	}

	@ExceptionHandler
	public ResponseEntity<ExceptionTemplate> handleInvalidCredentialsTemplateData(InvalidCredentialsException e) {
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg(e.getErrorMessage());
		template.setUserInput(e.getUserInput());
		template.setDateTime(new Timestamp(System.currentTimeMillis()));

		return new ResponseEntity<ExceptionTemplate>(template, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<ExceptionTemplate> handleInvalidUserNameTemplateData(InvalidUserNameException e) {
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg(e.getErrorMessage());
		template.setUserInput(e.getUserInput());
		template.setDateTime(new Timestamp(System.currentTimeMillis()));

		return new ResponseEntity<ExceptionTemplate>(template, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<ExceptionTemplate> handleInvalidPasswordTemplateData(InvalidPasswordException e) {
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg(e.getErrorMessage());
		template.setUserInput(e.getUserInput());
		template.setDateTime(new Timestamp(System.currentTimeMillis()));

		return new ResponseEntity<ExceptionTemplate>(template, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<ExceptionTemplate> handleInvalidRoleTemplateData(InvalidRoleException e) {
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg(e.getErrorMsg());
		template.setUserInput(e.getUserInput());
		template.setDateTime(new Timestamp(System.currentTimeMillis()));

		return new ResponseEntity<ExceptionTemplate>(template, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<ExceptionTemplate> handleIncorrectAnswerTemplateData(InvalidCorrectAnswerException e) {
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg(e.getErrorMsg());
		template.setUserInput(e.getUserInput());
		template.setDateTime(new Timestamp(System.currentTimeMillis()));

		return new ResponseEntity<ExceptionTemplate>(template, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<ExceptionTemplate> handleResourceNotFoundTemplateData(ResourceNotFoundException e) {
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg(e.getResourceName());
		template.setUserInput(e.getFieldValue());
		template.setDateTime(new Timestamp(System.currentTimeMillis()));

		return new ResponseEntity<ExceptionTemplate>(template, HttpStatus.BAD_REQUEST);
	}

}
