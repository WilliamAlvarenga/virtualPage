package com.app.vpage.execptionhandler.execption;

public class BadRequestException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	
	public BadRequestException(String message) {
		super(message);
	}
	
	
}
