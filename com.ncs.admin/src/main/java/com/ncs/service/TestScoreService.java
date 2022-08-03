package com.ncs.service;

import java.util.List;
import java.util.Set;

import com.ncs.model.Test_Score;

public interface TestScoreService {

	public Test_Score createTestScore(Test_Score ts);

	public Test_Score getTestScoreByID(int testScoreId);

	public Set<Test_Score> readTestScore(int studentId);

	public List<Test_Score> readAllTestScoreByUserID(int userId);

	public void editTestScore(Test_Score ts, int studentId);

	public boolean deleteTestScore(int testScoreId);

}
