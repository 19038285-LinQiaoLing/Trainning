package com.ncs.web;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ncs.dto.StudentTestScoreResponseDTO;
import com.ncs.dto.TestScoreResponseDTO;
import com.ncs.exception.InvalidCredentialsException;
import com.ncs.exception.ResourceNotFoundException;
import com.ncs.model.Question;
import com.ncs.model.Test_Score;
import com.ncs.model.User;
import com.ncs.service.QuestionService;
import com.ncs.service.TestScoreService;
import com.ncs.service.UserService;
import com.ncs.util.JWTUtil;
import com.ncs.util.TestScoreDTOConversion;

import io.jsonwebtoken.Jwts;

@RestController
@RequestMapping("/student")
public class StudentRestController {

	UserService userService;
	TestScoreService testScoreService;
	QuestionService questionService;

	@Autowired
	TestScoreDTOConversion dtoConversion;

	@Autowired
	JWTUtil jwtUtil;

	@Autowired
	RestTemplate restTemplate;

	private static final Logger loggerUser = LoggerFactory.getLogger(User.class);
	private static final Logger loggerQuestion = LoggerFactory.getLogger(Question.class);

	@Autowired
	public StudentRestController(UserService userService, TestScoreService testScoreService,
			QuestionService questionService) {
		System.out.println("Inside Student Rest Controller Constructor");
		this.userService = userService;
		this.testScoreService = testScoreService;
		this.questionService = questionService;
	}

	public String getUsernameFromToken(String token) {
		String username = null;
		if (token != null) {
			// parse the token.

			try {
				username = Jwts.parser().setSigningKey("secret").parseClaimsJws(token.replace("ncs-", "")).getBody()
						.getSubject();

			} catch (Exception e) {

				throw e;

			}
		}

		return username;
	}

	// Generic function to convert set to list
	public static <T> List<T> convertSetToList(Set<T> set) {
		// create an empty list
		List<T> list = new ArrayList<>();

		// push each element in the set into the list
		for (T t : set)
			list.add(t);

		// return the list
		return list;
	}

	public Boolean validateToken(String token) {
		String endPoint = "http://NCS-PROJECT-PUBLIC-SERVICE/public/validate";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", token);
		headers.set("userType", "student");

		String username = getUsernameFromToken(token);

		HttpEntity<String> header = new HttpEntity<String>(headers);
		ResponseEntity<Boolean> result = restTemplate.exchange(endPoint, HttpMethod.GET, header, Boolean.class);
		boolean jwtStatus = result.getBody();

		return jwtStatus;
	}

	// Get all results unique to current user (Student)
	@GetMapping("/results")
	public ResponseEntity<List<TestScoreResponseDTO>> getStudentResults(
			@RequestHeader(name = "Authorization") String token) throws Exception {
		loggerUser.info("Inside Edit User API Call");
		String username = getUsernameFromToken(token);

		if (validateToken(token)) {
			User userExists = userService.findUserByUsername(username);
			if (userExists == null) {
				throw new ResourceNotFoundException("Student with username: " + username + " not found", "Id", 0);
			} else {
				List<Test_Score> allTestResults = convertSetToList(userExists.getAllTestScore());
				List<TestScoreResponseDTO> resultsToShow = new ArrayList<>();
				for (Test_Score testScore : allTestResults) {
					resultsToShow.add(dtoConversion.convertToResponse(testScore));
				}
				return new ResponseEntity<List<TestScoreResponseDTO>>(resultsToShow, HttpStatus.OK);
			}

		} else {
			throw new Exception("Invalid Credentials");
		}

	}

	// Answer a list of questions
	@PostMapping("/exam/answer")
	@ResponseBody
	public ResponseEntity<StudentTestScoreResponseDTO> answerQuestions(
			@RequestHeader(name = "Authorization") String token, @RequestBody ArrayList<String> answers)
			throws Exception {
		loggerQuestion.info("Inside Answer Exam Questions API Call");
		String username = getUsernameFromToken(token);

		if (validateToken(token)) {
			ResponseEntity<List<Question>> examQuestions = restTemplate.exchange(
					"http://NCS-PROJECT-QUESTION-SERVICE/question/exam/examquestions", HttpMethod.GET, null,
					new ParameterizedTypeReference<List<Question>>() {
					});
			List<Question> questions = examQuestions.getBody();
			ArrayList<String> correctAnswers = new ArrayList<>();
			int totalMarks = 0;

			Question DTOQuestion = questions.get(0);

			for (Question dto : questions) {
				correctAnswers.add(dto.getCorrectAnswer());
			}

			for (int i = 0; i < 20; i++) {
				if (correctAnswers.get(i).equals(answers.get(i)))
					totalMarks++;
			}

			Date date = Date.valueOf(LocalDate.now());
			String questionLevel = "";
			if (DTOQuestion.getQuestionMarks() == 1)
				questionLevel = "Basic";
			else if (DTOQuestion.getQuestionMarks() == 2)
				questionLevel = "Intermediate";
			else if (DTOQuestion.getQuestionMarks() == 3)
				questionLevel = "Advanced";
			int totalScore = totalMarks * 5;

			Test_Score testScore = new Test_Score();
			testScore.setLevel(questionLevel);
			testScore.setCategory(DTOQuestion.getQuestionCategory());
			testScore.setDate(date);
			testScore.setMarks(totalScore);
			testScore.setTotalScore(20);

			User u = userService.findUserByUsername(username);
			userService.saveScore(u, testScore);

			int numberOfStudentsAboveYou = 0;
			numberOfStudentsAboveYou = testScoreService.getStudentsAboveYou(testScore, u);
			int numberOfStudentsBeneathYou = 0;
			numberOfStudentsBeneathYou = testScoreService.getStudentsBeneathYou(testScore, u);

			StudentTestScoreResponseDTO userTestScore = dtoConversion.convertToStudentResponseDTO(
					testScoreService.createTestScore(testScore), numberOfStudentsAboveYou, numberOfStudentsBeneathYou);

			return new ResponseEntity<StudentTestScoreResponseDTO>(userTestScore, HttpStatus.OK);
		} else {
			throw new InvalidCredentialsException("Invalid Credentials", null, 0);
		}

	}
}
