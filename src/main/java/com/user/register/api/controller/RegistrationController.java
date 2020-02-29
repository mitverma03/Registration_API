package com.user.register.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.register.api.exception.UniqueFieldViolationException;
import com.user.register.api.model.User;
import com.user.register.api.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Mitesh.varma
 *
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class RegistrationController {

	@Autowired
	private UserService userService;

	/**
	 * method to register new user with unique email
	 * 
	 * @param user
	 * @return unique user id
	 * @throws UniqueFieldViolationException 
	 */
	@PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Long> registerUser(@Valid @RequestBody User user) throws UniqueFieldViolationException {
		log.info("in registerUser controller.", user.toString());
		return ResponseEntity.ok().body(userService.registerUser(user));
	}
}
