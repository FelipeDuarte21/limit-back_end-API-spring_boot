package com.hackathon.limit.resource.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<ErrorModel> notFoundExceptionHandler(ObjectNotFoundException ex,
			HttpServletRequest request){
		
		ErrorModel em = new ErrorModel(HttpStatus.NOT_FOUND.value(),"Not Found",ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
	}
	
	@ExceptionHandler(ObjectBadRequestException.class)
	public ResponseEntity<ErrorModel> badRequestExceptionHandler(ObjectBadRequestException ex,
			HttpServletRequest request){
		
		ErrorModel em  = new ErrorModel(HttpStatus.BAD_REQUEST.value(),"Bad Request",ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(em);
	}
	
}
