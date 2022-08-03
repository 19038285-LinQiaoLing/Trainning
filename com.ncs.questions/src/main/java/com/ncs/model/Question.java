package com.ncs.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
public class Question implements Serializable, Comparable<Question> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private int questionNumber;
	@NotNull
	private String questionString;
	private String questionCategory;
	@NotNull
	private int questionMarks;
	@NotNull
	private String questionOptionOne;
	@NotNull
	private String questionOptionTwo;
	@NotNull
	private String questionOptionThree;
	@NotNull
	private String questionOptionFour;
	@NotNull
	private String correctAnswer;
	private boolean is_available = true;
	private Date date_created;
	private Timestamp date_updated;

	public Question() {
		super();
	}

	public Question(int questionNumber, String questionString) {
		super();
		this.questionNumber = questionNumber;
		this.questionString = questionString;
	}

	public Question(int questionNumber, String questionString, String questionCategory, int questionMarks,
			String questionOptionOne, String questionOptionTwo, String questionOptionThree, String questionOptionFour,
			String correctAnswer, boolean is_available, Date date_created, Timestamp date_updated) {
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
		this.is_available = is_available;
		this.date_created = date_created;
		this.date_updated = date_updated;
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

	public boolean isIs_available() {
		return is_available;
	}

	public void setIs_available(boolean is_available) {
		this.is_available = is_available;
	}

	public Date getDate_created() {
		return date_created;
	}

	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}

	public Timestamp getDate_updated() {
		return date_updated;
	}

	public void setDate_updated(Timestamp date_updated) {
		this.date_updated = date_updated;
	}

	@Override
	public int hashCode() {
		return Objects.hash(correctAnswer, date_created, date_updated, is_available, questionCategory, questionMarks,
				questionNumber, questionOptionFour, questionOptionOne, questionOptionThree, questionOptionTwo,
				questionString);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		return Objects.equals(correctAnswer, other.correctAnswer) && Objects.equals(date_created, other.date_created)
				&& Objects.equals(date_updated, other.date_updated) && is_available == other.is_available
				&& Objects.equals(questionCategory, other.questionCategory)
				&& Objects.equals(questionMarks, other.questionMarks) && questionNumber == other.questionNumber
				&& Objects.equals(questionOptionFour, other.questionOptionFour)
				&& Objects.equals(questionOptionOne, other.questionOptionOne)
				&& Objects.equals(questionOptionThree, other.questionOptionThree)
				&& Objects.equals(questionOptionTwo, other.questionOptionTwo)
				&& Objects.equals(questionString, other.questionString);
	}

	@Override
	public int compareTo(Question o) {
		// TODO Auto-generated method stub
		return this.questionNumber - o.questionNumber;
	}

}
