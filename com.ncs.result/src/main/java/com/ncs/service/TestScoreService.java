package com.ncs.service;

import java.util.List;

import com.ncs.model.Test_Score;
import com.ncs.model.User;

public interface TestScoreService {

	public Test_Score createTestScore(Test_Score ts);

	public Test_Score readTestScore(int testScoreId);

	public List<Test_Score> readAllTestScoreByUserID(int userId);

	public void editTestScore(Test_Score ts);

	public boolean deleteTestScore(int testScoreId);

	public int getStudentsAboveYou(Test_Score ts, User u);

	public int getStudentsBeneathYou(Test_Score ts, User u);

}
