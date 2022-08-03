package com.ncs.repository;

import java.util.List;

import com.ncs.model.User;

public interface CustomUserRepository {

	public List<User> getAllUsersByRole(String role);

	public boolean deleteUser(int userId);

}
