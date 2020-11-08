package com.suresh.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.suresh.binds.UserRequest;
import com.suresh.constants.AppConstants;
import com.suresh.props.AppProperties;
import com.suresh.service.UserService;

import io.swagger.annotations.ApiResponse;

@RestController
public class SSNEnrollmentController {
		@Autowired
		private UserService service;
		
		@Autowired
		private AppProperties props;
		
		@PostMapping(value = "/createEnroll",
					 consumes  = {"application/json"})
		public ResponseEntity<String> handleUserEnroll(@RequestBody UserRequest request){	
			
				 String ssn = service.saveUserEnroll(request);
				 String scsmsg=props.getMessage().get(AppConstants.SUCCESS_MSG)+ssn;
				return new ResponseEntity<String>(scsmsg,HttpStatus.CREATED);
		}
}