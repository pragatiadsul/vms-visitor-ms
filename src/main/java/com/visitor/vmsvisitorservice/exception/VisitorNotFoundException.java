package com.visitor.vmsvisitorservice.exception;

public class VisitorNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public VisitorNotFoundException(String errorMessage) {
		super(errorMessage);
	}

}
