package com.suresh.binds;

import java.util.Date;

import lombok.Data;

@Data
public class UserResponse {
	

	private String firstName;

	private String lastName;

	private String gender;

	private Date dob;

	private String stateName;

	//private Blob photo;
}
