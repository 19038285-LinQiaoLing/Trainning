package com.ncs.service;

import java.util.List;

import com.ncs.model.Question;

public interface QuestionService {

	public Question createQuestion(Question q);

	public Question readQuestion(int questionId);

	public List<Question> getAllQuestionByCategory(String category);

	public List<Question> getExamQuestions(String category, String level);

	public void editQuestion(Question q);

	public boolean deleteQuestion(int questionId);

}
