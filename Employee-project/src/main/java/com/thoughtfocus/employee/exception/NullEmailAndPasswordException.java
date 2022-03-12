package com.thoughtfocus.employee.exception;

public class NullEmailAndPasswordException extends RuntimeException {
	public NullEmailAndPasswordException(String msg) {
		super(msg);
	}
}
