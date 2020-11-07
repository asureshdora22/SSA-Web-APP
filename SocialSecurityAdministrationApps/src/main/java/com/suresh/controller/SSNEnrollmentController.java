package com.suresh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.suresh.binds.UserRequest;
import com.suresh.service.UserService;

import io.swagger.annotations.ApiResponse;

@RestController
public class SSNEnrollmentController {
		@Autowired
		private UserService service;
		
		
		@PostMapping(value = "/createEnroll",
					 consumes  = {"application/json"})
		public String handleUserEnroll(@RequestBody UserRequest request){	
			
				 String ssn = service.saveUserEnroll(request);
				 String scsmsg="Your SSN Enrollment  Completed.Your SSN : "+ssn;
				return scsmsg;
		}
}