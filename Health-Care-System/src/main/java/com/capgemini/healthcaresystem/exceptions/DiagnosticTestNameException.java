package com.capgemini.healthcaresystem.exceptions;

public class DiagnosticTestNameException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DiagnosticTestNameException() {
		super();
	}
	public DiagnosticTestNameException(String message) {
		super(message);
	}
}
