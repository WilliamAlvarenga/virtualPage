package com.app.vpage.execptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class VpageExceptionHandler extends ResponseEntityExceptionHandler{

	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		return super.handleMethodArgumentNotValid(ex, headers, status, request);
	}
	
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
	
		String menssageUser = messageSource.getMessage("messagem.invalida", null,LocaleContextHolder.getLocale());
		String menssageExcep = ex.getCause().toString();
		
		
		return handleExceptionInternal(ex, new Erro(menssageUser,menssageExcep), headers, HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler(value = { BadRequestException.class })
	public ResponseEntity<Object> badRequestExceptionHandler(BadRequestException ex, WebRequest request) {
		String userMessage = "Erro na solicitacao, algum parametro invalido";
				
		String menssageExcep = ex.getCause() != null ? ex.getCause().toString() : ex.toString();
	
		return handleExceptionInternal(ex, new Erro(userMessage,menssageExcep), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	public static class Erro {
		
		private String messageUser;
		private String messageExcep;
		
		public Erro(String messageUser, String messageExcep) {
			super();
			this.messageUser = messageUser;
			this.messageExcep = messageExcep;
		}

		public String getMessageUser() {
			return messageUser;
		}

		public String getMessageExcep() {
			return messageExcep;
		}
		
		
	}
	
	
	
}
