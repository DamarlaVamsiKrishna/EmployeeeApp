package com.thoughtfocus.employee.exception;

public class UnknownUserException extends RuntimeException {
	public UnknownUserException(String msg) {
		super(msg);
	}
}
