package com.ncs.dto;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.ncs.model.Test_Score;

@Component
public class UserResponseDTO {

	private int userId;
	private String username;
	private String role;
	private String email;
	private Set<Test_Score> allTestScore;

	public UserResponseDTO() {
		super();
	}

	public UserResponseDTO(int userId, String username, String role, String email, Set<Test_Score> allTestScore) {
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

	public Set<Test_Score> getAllTestScore() {
		return allTestScore;
	}

	public void setAllTestScore(Set<Test_Score> allTestScore) {
		this.allTestScore = allTestScore;
	}

	@Override
	public String toString() {
		return "UserResponseDTO [userId=" + userId + ", username=" + username + ", role=" + role + ", email=" + email
				+ ", allTestScore=" + allTestScore + "]";
	}

}
