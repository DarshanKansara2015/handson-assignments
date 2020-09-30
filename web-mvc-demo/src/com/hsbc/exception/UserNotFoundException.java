package com.hsbc.exception;

public class UserNotFoundException extends Exception{
	public UserNotFoundException(String message) {
		super(message);
	}

	public UserNotFoundException() {
		super("User Not Found");
	}

}
