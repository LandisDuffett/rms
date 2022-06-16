package com.reimburse.rms.exception;

public class UserNotFoundException extends Exception {
	
	public UserNotFoundException() {
	}
	
	@Override
	public String getMessage() {
		return "No user with that email and password combination found!";
	}
	
}
