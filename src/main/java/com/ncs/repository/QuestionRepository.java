package com.ncs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncs.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer>, CustomQuestionRepository{

}
