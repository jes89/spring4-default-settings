package com.brain.earthcitizenclub.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.brain.earthcitizenclub.dto.UserDTO;
import com.brain.earthcitizenclub.dto.UserDetailsDTO;
import com.brain.earthcitizenclub.mapper.UserMapper;

@Service
public class UserAuthenticationService implements UserDetailsService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		UserDTO user = userMapper.selectUserForSecurity(userId);
		
		if (user == null) {
			throw new UsernameNotFoundException(userId);
		}
		
		List<GrantedAuthority> gas = new ArrayList<GrantedAuthority>();
		gas.add(new SimpleGrantedAuthority(user.getRole()));
		return new UserDetailsDTO(user.getUserId(), user.getUserNm(), user.getPwd(), true, true, true, true, gas);
	
	}
}
