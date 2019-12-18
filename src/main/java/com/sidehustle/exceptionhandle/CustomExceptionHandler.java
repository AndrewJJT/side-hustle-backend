package com.sidehustle.exceptionhandle;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
//import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
	
	  @ExceptionHandler(ConstraintViolationException.class)
	    public void constraintViolationException(HttpServletResponse response) throws IOException {
	        response.sendError(HttpStatus.BAD_REQUEST.value());
	    }
}
