package com.ncs.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.ncs.model.Test_Score;
import com.ncs.model.User;

public interface UserService extends UserDetailsService {

	public User saveUser(User u);

	public User findUserById(int userId);

	public User findUserByEmail(String email);

	public User findUserByUsername(String username);

	public User findUserPassword(String password);

	public List<User> getAllUsers();

	public List<User> getAllUsersByRole(String role);

	public void editUser(User u);

	public boolean deleteUser(int userId);

	public void saveScore(User u, Test_Score ts);

}
