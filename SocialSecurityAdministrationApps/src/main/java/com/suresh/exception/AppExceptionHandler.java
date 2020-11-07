package com.suresh.exception;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.suresh.constants.AppConstants;
import com.suresh.props.AppProperties;

@RestController
@ControllerAdvice
public class AppExceptionHandler {

	@Autowired
	private AppProperties props;
	@ExceptionHandler(value = NullPointerException.class)
	public String handleNullPointerException() {
		return props.getMessage().get(AppConstants.NULLPOINTEREXCEPTION);
				
	}
	
	@ExceptionHandler(value = NoSSNFoundException.class)
	public ResponseEntity<AppError> handleNoSSNFoundException() {
		AppError error=new AppError(400,props.getMessage().get(AppConstants.NO_DATA_FOUND), new Date());
		return new ResponseEntity<AppError>(error,HttpStatus.BAD_REQUEST);
	}
	
}
