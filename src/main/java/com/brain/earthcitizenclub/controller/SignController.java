package com.brain.earthcitizenclub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignController {
	
	
	@RequestMapping("/login")
	protected String login(){
		
		return "/login/login";
	}
}
