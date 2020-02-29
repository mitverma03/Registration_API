package com.user.register.api.exception;

public class UniqueFieldViolationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UniqueFieldViolationException(String msg) {
		super(msg);
	}
}
