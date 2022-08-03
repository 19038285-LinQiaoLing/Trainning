package com.ncs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ncs.model.Test_Score;

public interface TestScoreRepository extends JpaRepository<Test_Score, Integer>, CustomTestScoreRepository {

	@Query("from Test_Score ts where ts.is_available = 1")
	public List<Test_Score> getAllTestScores();

}
