package com.user.register.api.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

import com.user.register.api.exception.UniqueFieldViolationException;
import com.user.register.api.model.User;
import com.user.register.api.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	@InjectMocks
	private UserService userService;

	@Mock
	private UserRepository userRepository;

	@Mock
	private User user;

	@Test
	void testUserRegister() throws UniqueFieldViolationException {
		when(userRepository.save(Mockito.any())).thenReturn(user);
		assertNotNull(userService.registerUser(user));
		Mockito.verify(userRepository, Mockito.atLeastOnce()).save(Mockito.any());
		
		userService.registerUser(user);
	}

	@Test
	void testUserRegisterWithException() throws UniqueFieldViolationException {
		when(userRepository.save(Mockito.any())).thenThrow(DataIntegrityViolationException.class);
		assertThrows(UniqueFieldViolationException.class, () -> userService.registerUser(user));
	}

}
