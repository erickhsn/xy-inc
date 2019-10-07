package com.xy.teste;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<ApiError> handleContentNotAllowedException(MethodArgumentNotValidException ex) {
		ArrayList<String> errors = new ArrayList<String>();
		errors.add(ex.getLocalizedMessage());
		return new ResponseEntity<ApiError>(new ApiError(errors), HttpStatus.BAD_REQUEST);
	}


}
