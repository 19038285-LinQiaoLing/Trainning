package com.ncs.web;

import org.apache.http.auth.InvalidCredentialsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.dto.JWTResponseDTO;
import com.ncs.exception.InvalidPasswordException;
import com.ncs.model.User;
import com.ncs.service.UserService;
import com.ncs.service.UserServiceImpl;
import com.ncs.util.JWTUtil;

@RestController
@RequestMapping("/public")
public class PublicController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserServiceImpl userServiceImpl;
	UserService userService;
	@Autowired
	JWTUtil jwtUtil;
	@Autowired
	PasswordValidator passwordValidator;

	private static final Logger logger = LoggerFactory.getLogger(User.class);

	@Autowired
	public PublicController(UserService userService) {
		System.out.println("Inside Public Rest Controller Constructor");
		this.userService = userService;
	}

	// Create User
	// Takes in a User body and checks with the database if the username/email
	// already exists
	// Returns a message stating success if successful
	@PostMapping("/register")
	@ResponseBody
	public ResponseEntity<?> createUser(@RequestBody User u) throws InvalidPasswordException {
		logger.info("Inside User Creation");

		if (!PasswordValidator.isValid(u.getPassword()))
			throw new InvalidPasswordException(
					"Password must contain at least one digit [0-9]."
							+ "Password must contain at least one lowercase Latin character [a-z]."
							+ "Password must contain at least one uppercase Latin character [A-Z]."
							+ "Password must contain at least one special character like ! @ # & ( )."
							+ "Password must contain a length of at least 8 characters and a maximum of 20 characters.",
					u.getPassword(), 0);

		User userExists = userService.findUserByUsername(u.getUsername());
		User emailExists = userService.findUserByEmail(u.getUsername());

		if (userExists != null) {
			return new ResponseEntity<>("There is already a user registered with the username provided", HttpStatus.OK);
		} else if (emailExists != null) {
			return new ResponseEntity<>("There is already a user registered with the email provided", HttpStatus.OK);

		} else

		{
			userService.saveUser(u);
			return new ResponseEntity<>("User successfully saved in the database", HttpStatus.OK);
		}
	}

	// Login
	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<JWTResponseDTO> loginUser(@RequestBody User u) throws InvalidCredentialsException {

		logger.info("Inside User Login");

		try {

			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(u.getUsername(), u.getPassword()));

		} catch (Exception e) {
			throw new InvalidCredentialsException("Invalid credentials");
		}

		UserDetails userDetails = userServiceImpl.loadUserByUsername(u.getUsername());

		String token = jwtUtil.generateToken(userDetails);

		boolean isValid = token != null ? true : false;

		JWTResponseDTO jwtResponseDTO = new JWTResponseDTO(token, u.getUsername(), isValid);

		return new ResponseEntity<JWTResponseDTO>(jwtResponseDTO, HttpStatus.OK);
	}

}
