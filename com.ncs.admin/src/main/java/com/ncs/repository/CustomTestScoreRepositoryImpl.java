package com.ncs.repository;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ncs.model.Test_Score;

public class CustomTestScoreRepositoryImpl implements CustomTestScoreRepository {

	@Autowired
	EntityManager springDataJPA;

	@Override
	public Test_Score readTestScore(int testScoreId) {
		String query = "from Test_Score ts where ts.testId = :testScoreId AND ts.is_available = 1";
		Query q = springDataJPA.createQuery(query, Test_Score.class);
		q.setParameter("testScoreId", testScoreId);
		try {

			Test_Score ts = (Test_Score) q.getSingleResult();

			return ts;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List<Test_Score> readAllTestScoreByUserID(int userId) {
		String query = "from Test_Score ts where ts.userId = :userId";
		Query q = springDataJPA.createQuery(query, Test_Score.class);
		q.setParameter("userId", userId);

		List<Test_Score> testScores = (List<Test_Score>) q.getResultList();
		return testScores;
	}

	@Override
	@Transactional
	public boolean deleteTestScore(int testScoreId) {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		String query = "update Test_Score ts set ts.is_available = 0, ts.date_updated = :date_updated where ts.test_id = :testScoreId";
		Query q = springDataJPA.createNativeQuery(query, Test_Score.class);
		q.setParameter("testScoreId", testScoreId);
		q.setParameter("date_updated", time);
		int x = q.executeUpdate();
		return (x == 1) ? true : false;
	}

}
