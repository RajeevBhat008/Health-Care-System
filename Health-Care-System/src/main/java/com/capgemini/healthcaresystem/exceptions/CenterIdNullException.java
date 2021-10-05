package com.capgemini.healthcaresystem.exceptions;

public class CenterIdNullException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CenterIdNullException() {
		super();
	}
	public CenterIdNullException(String msg) {
		super(msg);
	}
}
