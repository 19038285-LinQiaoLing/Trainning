package com.ncs.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.model.Question;
import com.ncs.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionRepository questionRepository;

	@Override
	public Question createQuestion(Question q) {
		if (q != null) {
			Date date = Date.valueOf(LocalDate.now());
			q.setDate_created(date);
			Question savedEntity = questionRepository.save(q);
			return savedEntity;

		} else {
			throw new NullPointerException("Question Info Is Null");
		}
	}

	@Override
	public Question readQuestion(int questionId) {
		return questionRepository.readQuestion(questionId);
	}

	@Override
	public List<Question> getAllQuestionByCategory(String category) {
		return questionRepository.getAllQuestionByCategory(category);
	}

	@Override
	public void editQuestion(Question editedQuestion, Question q) {
		if (editedQuestion.getQuestionString() != null)
			editedQuestion.setQuestionString(q.getQuestionString());
		if (editedQuestion.getQuestionCategory() != null)
			editedQuestion.setQuestionCategory(q.getQuestionCategory());
		if (editedQuestion.getQuestionMarks() != 0)
			editedQuestion.setQuestionMarks(q.getQuestionMarks());
		if (editedQuestion.getQuestionOptionOne() != null)
			editedQuestion.setQuestionOptionOne(q.getQuestionOptionOne());
		if (editedQuestion.getQuestionOptionTwo() != null)
			editedQuestion.setQuestionOptionTwo(q.getQuestionOptionTwo());
		if (editedQuestion.getQuestionOptionThree() != null)
			editedQuestion.setQuestionOptionThree(q.getQuestionOptionThree());
		if (editedQuestion.getQuestionOptionFour() != null)
			editedQuestion.setQuestionOptionFour(q.getQuestionOptionFour());
		if (editedQuestion.getCorrectAnswer() != null)
			editedQuestion.setCorrectAnswer(q.getCorrectAnswer());
		editedQuestion.setDate_updated(new Timestamp(System.currentTimeMillis()));
		questionRepository.save(editedQuestion);
	}

	@Override
	public List<Question> getExamQuestions(String category, String level) {
		return questionRepository.getExamQuestions(category, level);
	}

	@Override
	public boolean deleteQuestion(int questionId) {
		return questionRepository.deleteQuestion(questionId);
	}

}
