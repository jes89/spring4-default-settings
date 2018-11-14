package com.brain.earthcitizenclub.dao;

import com.brain.earthcitizenclub.dto.UserDTO;

public interface UserDAO {
	public UserDTO selectUserByUserId(String userId);
	public UserDTO selectUserForSecurity(String userId);
	
}
