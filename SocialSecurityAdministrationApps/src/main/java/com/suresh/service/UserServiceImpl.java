package com.suresh.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suresh.binds.UserRequest;
import com.suresh.binds.UserResponse;
import com.suresh.constants.AppConstants;
import com.suresh.entity.UserEntity;
import com.suresh.exception.NoSSNFoundException;
import com.suresh.props.AppProperties;
import com.suresh.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private AppProperties props;
	

	@Override
	public String formatSSN(String ssn) {
		StringBuilder builder=new StringBuilder();
		StringBuilder appendSSN = builder.append(ssn.substring(0, 3)).append("-")
		.append(ssn.substring(3, 5)).append("-")
		.append(ssn.substring(5, 9));
		
		return appendSSN.toString();
	}
	
	@Override
	public String saveUserEnroll(UserRequest user) {
		UserEntity entity=new UserEntity();
		BeanUtils.copyProperties(user, entity);
		UserEntity save = repo.save(entity);
		String enrollId=save.getEnrollId();
		String formatSSN = formatSSN(enrollId);
		return formatSSN;
		 
	}


	@Override
	public UserResponse findUserDetails(String ssnId) {
		Optional<UserEntity> optional = repo.findById(ssnId);
		
		if(optional.isPresent()) {
		UserEntity entity = optional.get();	
		UserResponse response=new UserResponse();
		BeanUtils.copyProperties(entity, response);
		return response;
		}
		else {
			throw new NoSSNFoundException(props.getMessage().get(AppConstants.INVALID_ID));
		}
	}



}
