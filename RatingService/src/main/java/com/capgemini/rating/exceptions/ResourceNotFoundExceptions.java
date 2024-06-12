package com.capgemini.rating.exceptions;

public class ResourceNotFoundExceptions extends RuntimeException {
	public ResourceNotFoundExceptions() {
		super("Resource not found in rating server !!");
	}
	
	public ResourceNotFoundExceptions(String message) {
		super(message);
	}
}
