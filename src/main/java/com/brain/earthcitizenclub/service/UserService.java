package com.brain.earthcitizenclub.service;

import com.brain.earthcitizenclub.dto.UserDTO;

public interface UserService {
	public UserDTO selectUserByUserId(String userId);
}
