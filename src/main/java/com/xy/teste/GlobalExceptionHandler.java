package com.xy.teste;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	
	@ExceptionHandler(BadRequest.class)
	protected ResponseEntity<String> handleContentNotAllowedException(BadRequest ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}


}
