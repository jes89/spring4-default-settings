package com.brain.earthcitizenclub.mapper;

import com.brain.earthcitizenclub.dto.UserDTO;

public interface UserMapper {
	public UserDTO selectUserForSecurity(String userId);
	public UserDTO selectUserByUserId(String userId);
}
