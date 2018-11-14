package com.brain.earthcitizenclub.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.brain.earthcitizenclub.dto.UserDTO;
import com.brain.earthcitizenclub.mapper.UserMapper;

@Repository("UserDAO")
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	UserMapper userMapper;
	
	public UserDTO selectUserByUserId(String userId){
		return userMapper.selectUserByUserId(userId);
	}
	public UserDTO selectUserForSecurity(String userId){
		return userMapper.selectUserForSecurity(userId);
	}
}
