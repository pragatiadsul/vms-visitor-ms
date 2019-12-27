package com.visitor.vmsvisitorservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(VisitorNotFoundException.class)
	public ResponseEntity<Object> visitorIdException(VisitorNotFoundException visitorIdException) {
		return new ResponseEntity<Object>("Visitor Not Found", HttpStatus.NOT_FOUND);
	}

}
