package com.capgemini.user.service.exceptions;

public class ResourceNotFoundexception extends RuntimeException{
	
	public ResourceNotFoundexception(){
		super("Resource not found on server!!");
	}
	
	public ResourceNotFoundexception(String message) {
		super(message);
	}
}
