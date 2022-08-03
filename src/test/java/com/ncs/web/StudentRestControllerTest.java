package com.ncs.web;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ncs.service.TestScoreService;
import com.ncs.service.UserService;
import com.ncs.util.TestScoreDTOConversion;

class StudentRestControllerTest {

	UserService userService;
	TestScoreService testScoreService;
	TestScoreDTOConversion dtoConversion;

	@BeforeEach
	void setUp() throws Exception {
		userService = mock(UserService.class);
		testScoreService = mock(TestScoreService.class);
		dtoConversion = mock(TestScoreDTOConversion.class);
	}

	@Test
	void test() {

		StudentRestController controller = new StudentRestController(userService, testScoreService, null);
	}

}
