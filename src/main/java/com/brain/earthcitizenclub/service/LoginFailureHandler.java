package com.brain.earthcitizenclub.service;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class LoginFailureHandler implements AuthenticationFailureHandler {
	
	 public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException auth) throws IOException, ServletException{	
		 response.sendRedirect("/sign/login?error=Badcredentials");
	 }
}
