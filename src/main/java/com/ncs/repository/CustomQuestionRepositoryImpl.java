package com.ncs.repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ncs.model.Question;

public class CustomQuestionRepositoryImpl implements CustomQuestionRepository {

	@Autowired
	EntityManager springDataJPA;

	@Override
	public Question readQuestion(int questionId) {
		String query = "from Question q where q.questionNumber = :questionId AND q.is_available = 1";
		Query q = springDataJPA.createQuery(query, Question.class);
		q.setParameter("questionId", questionId);
		try {
			Question question = (Question) q.getSingleResult();

			return question;
		} catch (NoResultException e) {

			return null;
		}

	}

	@Override
	public List<Question> getAllQuestionByCategory(String category) {
		String query = "from Question q where q.questionCategory = :questionCategory AND q.is_available = 1";
		Query q = springDataJPA.createQuery(query, Question.class);
		q.setParameter("questionCategory", category);
		try {
			List<Question> questions = (List<Question>) q.getResultList();

			return questions;
		} catch (NoResultException e) {

			return null;
		}
	}

	@Override
	public List<Question> getExamQuestions(String category, String level) {
		int questionLevel = 0;
		if (level.equalsIgnoreCase("Basic"))
			questionLevel = 1;
		else if (level.equalsIgnoreCase("Intermediate"))
			questionLevel = 2;
		else if (level.equalsIgnoreCase("Advanced"))
			questionLevel = 3;
		String query = "from Question q where q.questionCategory = :category AND q.questionMarks = :level AND q.is_available = 1";
		Query q = springDataJPA.createQuery(query, Question.class);
		q.setParameter("category", category);
		q.setParameter("level", questionLevel);
		try {
			List<Question> questions = q.getResultList();
			List<Question> randomTwentyQuestions = new ArrayList<>();

			int count = 20;
			Random rand = new Random();
			while (count > 0) {
				Question question = questions.get(rand.nextInt(questions.size()));
				randomTwentyQuestions.add(question);
				questions.remove(question);

				count--;
			}

			return randomTwentyQuestions;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	@Transactional
	public boolean deleteQuestion(int questionId) {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		String query = "update Question q set q.is_available = 0, q.date_updated = :date_updated where q.question_number =:questionNumber";
		Query q = springDataJPA.createNativeQuery(query, Question.class);
		q.setParameter("questionNumber", questionId);
		q.setParameter("date_updated", time);
		int x = q.executeUpdate();

		return (x == 1) ? true : false;
	}

}
