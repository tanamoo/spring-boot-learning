package com.momo.springbootlearning.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.momo.springbootlearning.entity.User;

public interface UserRepository extends JpaRepository <User, Long> {
	
	User findByUserName (String userName);
	User findByUserNameOrEmail (String username, String email);

}
