package com.user.register.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.user.register.api.exception.UniqueFieldViolationException;
import com.user.register.api.model.User;
import com.user.register.api.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository repository;

	public long registerUser(User user) throws UniqueFieldViolationException {
		log.info("In UserService.registerUser.");
		User u;
		try {
			u = repository.save(user);
		} catch (DataIntegrityViolationException e) {
			throw new UniqueFieldViolationException("unique value required for email address field.");
		}
		log.info("Exit UserService.registerUser.");
		return u.getUserId();
	}
}
