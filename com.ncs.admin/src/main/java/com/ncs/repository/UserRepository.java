package com.ncs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ncs.model.User;

public interface UserRepository extends JpaRepository<User, Integer>, CustomUserRepository {
	@Query("from User u where u.username = :username AND u.is_available = 1")
	public User getUsersByUsername(String username);

	@Query("from User u where u.userId = :userId AND u.is_available = 1")
	public User findUserById(int userId);

	@Query("from User u where u.email = :email AND u.is_available = 1")
	public User findUserByEmail(String email);

	@Query("from User u where u.username = :username AND u.is_available = 1")
	public User findUserByUsername(String username);

	@Query("from User u where u.password = :password AND u.is_available = 1")
	public User findByPassword(String password);

	@Query("from User u where u.role = 'student' AND u.is_available = 1")
	public List<User> getAllStudents();
}
