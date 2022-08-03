package com.ncs.repository;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ncs.model.User;

public class CustomUserRepositoryImpl implements CustomUserRepository {

	@Autowired
	EntityManager springDataJPA;

	@Override
	public List<User> getAllUsersByRole(String role) {
		String query = "from User u where u.role = :role AND u.is_available = 1";
		Query q = springDataJPA.createQuery(query, User.class);
		q.setParameter("role", role);
		try {

			List<User> listOfUsers = (List<User>) q.getResultList();

			return listOfUsers;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	@Transactional
	public boolean deleteUser(int userId) {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		String query = "update User u set u.is_available = 0, u.date_updated = :date_updated where u.user_id = :user_id";
		Query q = springDataJPA.createNativeQuery(query, User.class);
		q.setParameter("user_id", userId);
		q.setParameter("date_updated", time);
		int x = q.executeUpdate();
		return (x == 1) ? true : false;
	}

}
