package com.ncs.dto;

import org.springframework.stereotype.Component;

@Component
public class QuestionResponseDTO {

	private int questionNumber;
	private String questionString;
	private String questionCategory;
	private int questionMarks;
	private String questionOptionOne;
	private String questionOptionTwo;
	private String questionOptionThree;
	private String questionOptionFour;
	private String correctAnswer;

	public QuestionResponseDTO() {
		super();
	}

	public QuestionResponseDTO(int questionNumber, String questionString, String questionCategory, int questionMarks,
			String questionOptionOne, String questionOptionTwo, String questionOptionThree, String questionOptionFour,
			String correctAnswer) {
		super();
		this.questionNumber = questionNumber;
		this.questionString = questionString;
		this.questionCategory = questionCategory;
		this.questionMarks = questionMarks;
		this.questionOptionOne = questionOptionOne;
		this.questionOptionTwo = questionOptionTwo;
		this.questionOptionThree = questionOptionThree;
		this.questionOptionFour = questionOptionFour;
		this.correctAnswer = correctAnswer;
	}

	public int getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}

	public String getQuestionString() {
		return questionString;
	}

	public void setQuestionString(String questionString) {
		this.questionString = questionString;
	}

	public String getQuestionCategory() {
		return questionCategory;
	}

	public void setQuestionCategory(String questionCategory) {
		this.questionCategory = questionCategory;
	}

	public int getQuestionMarks() {
		return questionMarks;
	}

	public void setQuestionMarks(int questionMarks) {
		this.questionMarks = questionMarks;
	}

	public String getQuestionOptionOne() {
		return questionOptionOne;
	}

	public void setQuestionOptionOne(String questionOptionOne) {
		this.questionOptionOne = questionOptionOne;
	}

	public String getQuestionOptionTwo() {
		return questionOptionTwo;
	}

	public void setQuestionOptionTwo(String questionOptionTwo) {
		this.questionOptionTwo = questionOptionTwo;
	}

	public String getQuestionOptionThree() {
		return questionOptionThree;
	}

	public void setQuestionOptionThree(String questionOptionThree) {
		this.questionOptionThree = questionOptionThree;
	}

	public String getQuestionOptionFour() {
		return questionOptionFour;
	}

	public void setQuestionOptionFour(String questionOptionFour) {
		this.questionOptionFour = questionOptionFour;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	@Override
	public String toString() {
		return "QuestionResponseDTO [questionNumber=" + questionNumber + ", questionString=" + questionString
				+ ", questionCategory=" + questionCategory + ", questionMarks=" + questionMarks + ", questionOptionOne="
				+ questionOptionOne + ", questionOptionTwo=" + questionOptionTwo + ", questionOptionThree="
				+ questionOptionThree + ", questionOptionFour=" + questionOptionFour + ", correctAnswer="
				+ correctAnswer + "]";
	}

}
