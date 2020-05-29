package com.app.vpage.execptionhandler;

public class NotContentException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public NotContentException(String messege) {
		super(messege);
	}
}
