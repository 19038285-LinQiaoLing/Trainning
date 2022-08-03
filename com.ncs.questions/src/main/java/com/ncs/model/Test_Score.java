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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
public class Test_Score implements Serializable, Comparable<Test_Score> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private int testId;
	private Date date;
	private String category;
	private String level;
	private int totalScore;
	private int marks;
	private boolean is_available = true;
	private Date date_created;
	private Timestamp date_updated;

	public Test_Score() {
		super();
	}

	public Test_Score(int testId, Date date, String category, String level, int totalScore, int marks,
			boolean is_available, Date date_created, Timestamp date_updated) {
		super();
		this.testId = testId;
		this.date = date;
		this.category = category;
		this.level = level;
		this.totalScore = totalScore;
		this.marks = marks;
		this.is_available = is_available;
		this.date_created = date_created;
		this.date_updated = date_updated;
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
		return Objects.hash(category, date, date_created, date_updated, is_available, level, marks, testId, totalScore);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Test_Score other = (Test_Score) obj;
		return Objects.equals(category, other.category) && Objects.equals(date, other.date)
				&& Objects.equals(date_created, other.date_created) && Objects.equals(date_updated, other.date_updated)
				&& is_available == other.is_available && Objects.equals(level, other.level) && marks == other.marks
				&& testId == other.testId && totalScore == other.totalScore;
	}

	@Override
	public String toString() {
		return "Test_Score [testId=" + testId + ", date=" + date + ", category=" + category + ", level=" + level
				+ ", totalScore=" + totalScore + ", marks=" + marks + ", is_available=" + is_available
				+ ", date_created=" + date_created + ", date_updated=" + date_updated + "]";
	}

	@Override
	public int compareTo(Test_Score o) {
		// TODO Auto-generated method stub
		return this.testId - o.testId;
	}

}
