package com.suresh.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name="UserEnroll")
public class UserEntity {
	
	@Id
	@Column(name = "SSN_ID")
	@GenericGenerator(name = "enroll-id-gen",strategy = "com.suresh.generator.SSNGenerator")
	@GeneratedValue(generator = "enroll-id-gen")
	private String enrollId;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "DATE_OF_BIRTH")
	private Date dob;
	
	@Column(name = "STATE_NAME")
	private String stateName;
	
	//@Column(name = "PHOTO")
	//private Blob photo;
	

}
