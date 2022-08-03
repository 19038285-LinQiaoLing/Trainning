package com.ncs.util;

import org.springframework.stereotype.Component;

import com.ncs.dto.QuestionResponseDTO;
import com.ncs.model.Question;

@Component
public class QuestionDTOConversion {

	public static QuestionResponseDTO convertToResponse(Question q) {

		QuestionResponseDTO dto = new QuestionResponseDTO();

		dto.setQuestionNumber(q.getQuestionNumber());
		dto.setQuestionString(q.getQuestionString());
		dto.setQuestionCategory(q.getQuestionCategory());
		dto.setQuestionMarks(q.getQuestionMarks());
		dto.setQuestionOptionOne(q.getQuestionOptionOne());
		dto.setQuestionOptionTwo(q.getQuestionOptionTwo());
		dto.setQuestionOptionThree(q.getQuestionOptionThree());
		dto.setQuestionOptionFour(q.getQuestionOptionFour());
		dto.setCorrectAnswer(q.getCorrectAnswer());

		return dto;
	}

}
