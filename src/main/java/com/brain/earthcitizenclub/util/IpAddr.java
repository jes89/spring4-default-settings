package com.brain.earthcitizenclub.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class IpAddr {
	 
	
	public String GetIpAddr() {
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
	     String ip = req.getHeader("X-FORWARDED-FOR");
	     if (ip == null){
	         ip = req.getRemoteAddr();
		}
	     return ip;
	}
}
