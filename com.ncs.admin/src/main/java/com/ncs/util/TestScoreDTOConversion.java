package com.ncs.util;

import com.ncs.dto.TestScoreResponseDTO;
import com.ncs.model.Test_Score;

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

}
