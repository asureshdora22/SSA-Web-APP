package com.suresh.service;



import com.suresh.binds.UserRequest;
import com.suresh.binds.UserResponse;


public interface UserService {

	public String formatSSN(String ssn);
	public String saveUserEnroll(UserRequest user);
	
	public UserResponse findUserDetails(String ssnId);
}
