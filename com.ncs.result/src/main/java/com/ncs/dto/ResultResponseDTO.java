package com.ncs.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ResultResponseDTO {

	private int userId;
	private String username;
	private String role;
	private String email;
	private List<TestScoreResponseDTO> allTestScore;

	public ResultResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResultResponseDTO(int userId, String username, String role, String email,
			List<TestScoreResponseDTO> allTestScore) {
		super();
		this.userId = userId;
		this.username = username;
		this.role = role;
		this.email = email;
		this.allTestScore = allTestScore;
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

	public List<TestScoreResponseDTO> getAllTestScore() {
		return allTestScore;
	}

	public void setAllTestScore(List<TestScoreResponseDTO> allTestScore) {
		this.allTestScore = allTestScore;
	}

	@Override
	public String toString() {
		return "ResultResponseDTO [userId=" + userId + ", username=" + username + ", role=" + role + ", email=" + email
				+ ", allTestScore=" + allTestScore + "]";
	}

}
