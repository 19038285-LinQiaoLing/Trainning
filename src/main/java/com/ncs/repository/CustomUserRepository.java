package com.ncs.repository;

import java.util.List;

import com.ncs.model.User;

public interface CustomUserRepository {

	public User findUserById(int userId);

	public User findUserByEmail(String email);

	public User findUserByUsername(String username);

	public User findByPassword(String password);

	public List<User> getAllUsersByRole(String role);

	public boolean deleteUser(int userId);

}
