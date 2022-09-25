package com.springdemo.exception;

import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public ResourceNotFoundException() {}
	
	public ResourceNotFoundException(String msg)
	{
		super(msg);
		this.message = msg;
	}

}
