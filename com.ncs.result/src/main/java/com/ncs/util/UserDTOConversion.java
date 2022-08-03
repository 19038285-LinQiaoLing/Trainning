package com.ncs.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ncs.dto.ResultResponseDTO;
import com.ncs.dto.TestScoreResponseDTO;
import com.ncs.dto.UserResponseDTO;
import com.ncs.model.User;

@Component
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

		dto.setUsername(u.getUsername());
		dto.setRole(u.getRole());
		dto.setEmail(u.getEmail());

		return dto;
	}

	public static ResultResponseDTO convertToResultResponse(User u, List<TestScoreResponseDTO> testScores) {
		ResultResponseDTO dto = new ResultResponseDTO();

		dto.setUserId(u.getUserId());
		dto.setUsername(u.getUsername());
		dto.setRole(u.getRole());
		dto.setEmail(u.getEmail());
		dto.setAllTestScore(testScores);

		return dto;
	}

}
