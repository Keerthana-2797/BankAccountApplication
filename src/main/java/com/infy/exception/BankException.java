package com.infy.exception;

public class BankException extends Exception {
	private static final long serialVersionUID = 1L;

	public BankException() {
		super();
	}

	public BankException(String errors) {
		super(errors);
	}
}
