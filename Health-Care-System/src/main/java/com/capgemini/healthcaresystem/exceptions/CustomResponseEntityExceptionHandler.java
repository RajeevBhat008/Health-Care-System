package com.capgemini.healthcaresystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
		public final ResponseEntity<Object> handleDiagnosticCenterIDException(DiagnosticCenterIDException ex,
				WebRequest request){
			DiagnosticCenterIDExceptionResponse exceptionResponse=new DiagnosticCenterIDExceptionResponse(ex.getMessage());
			return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_REQUEST);
			
		}
		public final ResponseEntity<Object> handleDiagnosticCenterNameException(DiagnosticCenterNameException ex,
				WebRequest request){
			DiagnosticCenterNameExceptionResponse exceptionResponse=new DiagnosticCenterNameExceptionResponse(ex.getMessage());
			return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_REQUEST);
			
		}
		public final ResponseEntity<Object> handleDiagnosticTestNameException(DiagnosticTestNameException e,
				WebRequest request){
			DiagnosticTestNameExceptionResponse exceptionResponse=new DiagnosticTestNameExceptionResponse(e.getMessage());
			return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_REQUEST);
			
		}
		public final ResponseEntity<Object> handleCenterIdNullException(CenterIdNullException e,
				WebRequest request){
			CenterIdNullExceptionResponse exceptionResponse=new CenterIdNullExceptionResponse(e.getMessage());
			return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_REQUEST);
			
		}
}
