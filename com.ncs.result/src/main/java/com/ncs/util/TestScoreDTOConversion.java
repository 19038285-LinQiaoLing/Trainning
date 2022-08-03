package com.ncs.util;

import org.springframework.stereotype.Component;

import com.ncs.dto.StudentTestScoreResponseDTO;
import com.ncs.dto.TestScoreResponseDTO;
import com.ncs.model.Test_Score;

@Component
public class TestScoreDTOConversion {

	public static TestScoreResponseDTO convertToResponse(Test_Score ts) {
		TestScoreResponseDTO dto = new TestScoreResponseDTO();

		dto.setTestId(ts.getTestId());
		dto.setDate(ts.getDate());
		dto.setCategory(ts.getCategory());
		dto.setLevel(ts.getLevel());
		dto.setTotalScore(ts.getTotalScore());
		dto.setMarks(ts.getMarks());

		return dto;
	}

	public static StudentTestScoreResponseDTO convertToStudentResponseDTO(Test_Score ts, int studentsAboveYou,
			int studentsBeneathYou) {

		StudentTestScoreResponseDTO dto = new StudentTestScoreResponseDTO();

		dto.setTestId(ts.getTestId());
		dto.setDate(ts.getDate());
		dto.setCategory(ts.getCategory());
		dto.setLevel(ts.getLevel());
		dto.setTotalScore(ts.getTotalScore());
		dto.setMarks(ts.getMarks());
		dto.setStudentsAboveYou(studentsAboveYou);
		dto.setStudentsBeneathYou(studentsBeneathYou);

		return dto;
	}

}
