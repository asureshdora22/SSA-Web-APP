package com.suresh.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suresh.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Serializable>{

}
