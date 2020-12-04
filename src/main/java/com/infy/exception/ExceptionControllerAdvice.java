package com.infy.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infy.utility.InfyBankConstants;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	@Autowired
	private Environment environment;

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> exceptionHandler2(Exception ex) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage(environment.getProperty(InfyBankConstants.GENERAL_EXCEPTION_MESSAGE.toString()));
		return new ResponseEntity<>(error, HttpStatus.OK);
	}

	@ExceptionHandler(BankException.class)
	public ResponseEntity<ErrorMessage> exceptionHandler2(BankException ex) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
