package com.brain.earthcitizenclub.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import com.brain.earthcitizenclub.dto.UserDTO;


@Service
public class LoginSuccessHandler implements AuthenticationSuccessHandler{
	
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession){
	        this.sqlSession=sqlSession;
    }
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//		String userId = SecurityContextHolder.getContext().getAuthentication().getName();
		String path = null;
//		sqlSession.insert("user.insertLoginLog",userId);
//		sqlSession.update("user.updateLastLoginDtm",userId);
//		UserDTO userDTO = sqlSession.selectOne("user.selectUser",userId);
//		String nowDtm = this.getDate();
//		int now = Integer.parseInt(nowDtm);
//		int pwdDtm = Integer.parseInt(tempPwdDtm);
//
//		if(now >= pwdDtm ){
//			path = "/sign/shouldChangePwd";
//		} else{
			path = "/";
//		}
		
		response.sendRedirect(path);
		
	}


}
