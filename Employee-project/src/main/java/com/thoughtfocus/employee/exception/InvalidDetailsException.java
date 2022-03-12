package com.thoughtfocus.employee.exception;

public class InvalidDetailsException extends RuntimeException {
	public InvalidDetailsException(String msg) {
		super(msg);
	}
}
