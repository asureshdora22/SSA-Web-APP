package com.suresh.exception;

import java.util.Date;

import lombok.Data;

@Data
public class AppError {

	private Integer errorCode;
	private String errorDes;
	private Date date;
	public AppError(Integer errorCode, String errorDes, Date date) {
		super();
		this.errorCode = errorCode;
		this.errorDes = errorDes;
		this.date = date;
	}
	
	
}
