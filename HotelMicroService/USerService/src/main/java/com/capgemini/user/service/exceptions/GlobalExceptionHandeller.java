package com.capgemini.user.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.user.service.payload.ApiResponce;

@RestControllerAdvice
public class GlobalExceptionHandeller {
	
	@ExceptionHandler(ResourceNotFoundexception.class)
	public ResponseEntity<ApiResponce> handleResourceNotFoundException(ResourceNotFoundexception ex){
		String message = ex.getMessage();
		ApiResponce responce = ApiResponce.builder().message(message).success(false).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<ApiResponce>(responce,HttpStatus.NOT_FOUND);
	}
}
