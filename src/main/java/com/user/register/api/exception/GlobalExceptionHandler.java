package com.user.register.api.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<?> validationException(MethodArgumentNotValidException ex) {
		List<ErrorResponse> errors = new ArrayList<>();
		ex.getBindingResult().getAllErrors().forEach(error -> {
			errors.add(new ErrorResponse("validation failed.", error.getDefaultMessage()));
		});
		return new ResponseEntity(errors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<?> handleContrainViolationException(UniqueFieldViolationException ex){
		ErrorResponse error = new ErrorResponse("UniqueConstrain", ex.getMessage());
		return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	}
	
	
}
