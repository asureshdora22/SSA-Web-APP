package com.suresh.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suresh.binds.UserResponse;
import com.suresh.service.UserService;

@RestController
public class SSNEnrollVerfication {

	@Autowired
	private UserService service;

	@GetMapping(value = "/getUserDtls")
	public ResponseEntity<UserResponse> getSSNDtlsByUsngSSN(@RequestParam("ssn") String ssn) {
		UserResponse response = service.findUserDetails(ssn);
		
			return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
		
	}
}
