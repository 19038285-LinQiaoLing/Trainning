package com.ncs.repository;

import java.util.List;

import com.ncs.model.Test_Score;

public interface CustomTestScoreRepository {

	public Test_Score readTestScore(int testScoreId);

	public List<Test_Score> readAllTestScoreByUserID(int userId);

	public boolean deleteTestScore(int testScoreId);

}
