package com.brain.earthcitizenclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brain.earthcitizenclub.dao.UserDAO;
import com.brain.earthcitizenclub.dto.UserDTO;

@Service("UserService")
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO userDAO;
	
	public UserDTO selectUserByUserId(String userId) {
		return userDAO.selectUserByUserId(userId);
	}
}
