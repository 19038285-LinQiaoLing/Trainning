package com.ncs.util;

import java.util.List;

import com.ncs.dto.StudentAverageTestScoreResponseDTO;
import com.ncs.dto.TestScoreResponseDTO;
import com.ncs.dto.UserResponseDTO;
import com.ncs.dto.UserTestScoreResponseDTO;
import com.ncs.model.User;

public class UserDTOConversion {

	public static UserResponseDTO convertToResponse(User u) {
		UserResponseDTO dto = new UserResponseDTO();

		dto.setUserId(u.getUserId());
		dto.setUsername(u.getUsername());
		dto.setRole(u.getRole());
		dto.setEmail(u.getEmail());
		dto.setAllTestScore(u.getAllTestScore());

		return dto;
	}

	public static UserResponseDTO convertToRoleResponse(User u) {
		UserResponseDTO dto = new UserResponseDTO();

		dto.setUserId(u.getUserId());
		dto.setUsername(u.getUsername());
		dto.setRole(u.getRole());
		dto.setEmail(u.getEmail());

		return dto;
	}

	public static UserTestScoreResponseDTO convertToUserTestScoreResponse(User u,
			List<TestScoreResponseDTO> testScores) {
		UserTestScoreResponseDTO dto = new UserTestScoreResponseDTO();

		dto.setUserId(u.getUserId());
		dto.setUsername(u.getUsername());
		dto.setRole(u.getRole());
		dto.setEmail(u.getEmail());
		dto.setAllTestScore(testScores);

		return dto;
	}

	public static StudentAverageTestScoreResponseDTO convertToAverageTestScoreResponse(User u, int averageTestScore) {

		StudentAverageTestScoreResponseDTO dto = new StudentAverageTestScoreResponseDTO();

		dto.setUserId(u.getUserId());
		dto.setUsername(u.getUsername());
		dto.setRole(u.getRole());
		dto.setEmail(u.getEmail());
		dto.setAverageScore(averageTestScore);

		return dto;

	}

}
