package com.ncs.dto;

import org.springframework.stereotype.Component;

@Component
public class StudentAverageTestScoreResponseDTO {

	private int userId;
	private String username;
	private String role;
	private String email;
	private int averageScore;

	public StudentAverageTestScoreResponseDTO() {
		super();
	}

	public StudentAverageTestScoreResponseDTO(int userId, String username, String role, String email,
			int averageScore) {
		super();
		this.userId = userId;
		this.username = username;
		this.role = role;
		this.email = email;
		this.averageScore = averageScore;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(int averageScore) {
		this.averageScore = averageScore;
	}

	@Override
	public String toString() {
		return "StudentAverageTestScoreResponseDTO [userId=" + userId + ", username=" + username + ", role=" + role
				+ ", email=" + email + ", averageScore=" + averageScore + "]";
	}

}
