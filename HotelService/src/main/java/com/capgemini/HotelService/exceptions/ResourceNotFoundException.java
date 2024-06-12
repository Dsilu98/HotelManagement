package com.capgemini.HotelService.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	public ResourceNotFoundException() {
		super("Resource not found on hotel server !!");
	}
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
