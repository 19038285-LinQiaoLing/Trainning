package com.ncs.util;

import org.springframework.stereotype.Component;

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

}
