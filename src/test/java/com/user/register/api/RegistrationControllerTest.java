package com.user.register.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.user.register.api.controller.RegistrationController;
import com.user.register.api.model.User;
import com.user.register.api.service.UserService;

@ExtendWith(MockitoExtension.class)
public class RegistrationControllerTest {

	@InjectMocks
	private RegistrationController controller;

	@Mock
	private UserService userService;

	private Long userId = 101l;

	@Test
	public void testRegisterUser() throws JsonProcessingException, Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		when(userService.registerUser(Mockito.any())).thenReturn(userId);

		User user = new User();
		user.setUserName("testUser");
		user.setEmail("test@gmail.com");
		user.setMobile("9898989898");
		user.setPincode("356485");

		ResponseEntity<Long> responseEntity = controller.registerUser(user);
		assertEquals(responseEntity.getStatusCodeValue(), 200);
		assertEquals(responseEntity.getBody().intValue(),userId);
	}
}
