package com.ncs.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ncs.dto.QuestionResponseDTO;
import com.ncs.exception.InvalidCredentialsException;
import com.ncs.model.Question;
import com.ncs.model.User;
import com.ncs.service.QuestionService;
import com.ncs.service.TestScoreService;
import com.ncs.service.UserService;
import com.ncs.util.JWTUtil;
import com.ncs.util.QuestionDTOConversion;
import com.ncs.util.TestScoreDTOConversion;

@RestController
@RequestMapping("/question")
public class QuestionRestController {

	UserService userService;
	TestScoreService testScoreService;
	QuestionService questionService;

	@Autowired
	TestScoreDTOConversion testScoreConversion;

	@Autowired
	QuestionDTOConversion questionConversion;

	@Autowired
	JWTUtil jwtUtil;

	@Autowired
	RestTemplate restTemplate;

	private static final Logger loggerUser = LoggerFactory.getLogger(User.class);

	List<Question> allQuestions = new ArrayList<>();

	@Autowired
	public QuestionRestController(UserService userService, TestScoreService testScoreService,
			QuestionService questionService) {
		System.out.println("Inside Student Rest Controller Constructor");
		this.userService = userService;
		this.testScoreService = testScoreService;
		this.questionService = questionService;
	}

	public Boolean validateToken(String token) {
		String endPoint = "http://NCS-PROJECT-PUBLIC-SERVICE/public/validate";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", token);
		headers.set("userType", "student");

		HttpEntity<String> header = new HttpEntity<String>(headers);
		ResponseEntity<Boolean> result = restTemplate.exchange(endPoint, HttpMethod.GET, header, Boolean.class);
		boolean jwtStatus = result.getBody();

		return jwtStatus;
	}

	// Returns the list of questions to student
	@GetMapping("/exam/examquestions")
	public ResponseEntity<List<Question>> getExamQuestions() {
		return new ResponseEntity<List<Question>>(allQuestions, HttpStatus.OK);
	}

	// Get all exam questions
	// Takes in two required parameters
	// Returns a list of twenty random questions to the frontend
	@GetMapping("/exam/attempt")
	public ResponseEntity<List<QuestionResponseDTO>> showExamQuestions(@RequestParam(required = true) String category,
			@RequestParam(required = true) String level) throws InvalidCredentialsException {
		loggerUser.info("Inside Get Exam Questions API Call");

		allQuestions = questionService.getExamQuestions(category, level);
		List<QuestionResponseDTO> questionsToStudent = new ArrayList<>();
		int count = 1;
		for (Question question : allQuestions) {
			question.setQuestionNumber(count++);
			questionsToStudent.add(questionConversion.convertToResponse(question));

		}
		return new ResponseEntity<List<QuestionResponseDTO>>(questionsToStudent, HttpStatus.OK);
	}
}
