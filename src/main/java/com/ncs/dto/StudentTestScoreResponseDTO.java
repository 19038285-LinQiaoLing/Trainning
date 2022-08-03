package com.ncs.dto;

import java.sql.Date;
import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
public class StudentTestScoreResponseDTO {

	private int testId;
	private Date date;
	private String category;
	private String level;
	private int totalScore;
	private int marks;
	private int studentsAboveYou;
	private int studentsBeneathYou;

	public StudentTestScoreResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentTestScoreResponseDTO(int testId, Date date, String category, String level, int totalScore, int marks,
			int studentsAboveYou, int studentsBeneathYou) {
		super();
		this.testId = testId;
		this.date = date;
		this.category = category;
		this.level = level;
		this.totalScore = totalScore;
		this.marks = marks;
		this.studentsAboveYou = studentsAboveYou;
		this.studentsBeneathYou = studentsBeneathYou;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public int getStudentsAboveYou() {
		return studentsAboveYou;
	}

	public void setStudentsAboveYou(int studentsAboveYou) {
		this.studentsAboveYou = studentsAboveYou;
	}

	public int getStudentsBeneathYou() {
		return studentsBeneathYou;
	}

	public void setStudentsBeneathYou(int studentsBeneathYou) {
		this.studentsBeneathYou = studentsBeneathYou;
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, date, level, marks, studentsAboveYou, studentsBeneathYou, testId, totalScore);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentTestScoreResponseDTO other = (StudentTestScoreResponseDTO) obj;
		return Objects.equals(category, other.category) && Objects.equals(date, other.date)
				&& Objects.equals(level, other.level) && marks == other.marks
				&& studentsAboveYou == other.studentsAboveYou && studentsBeneathYou == other.studentsBeneathYou
				&& testId == other.testId && totalScore == other.totalScore;
	}

	@Override
	public String toString() {
		return "StudentTestScoreResponseDTO [testId=" + testId + ", date=" + date + ", category=" + category
				+ ", level=" + level + ", totalScore=" + totalScore + ", marks=" + marks + ", studentsAboveYou="
				+ studentsAboveYou + ", studentsBeneathYou=" + studentsBeneathYou + "]";
	}

}
