package com.brain.earthcitizenclub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/user")
public class UserController {

	@RequestMapping("/myPage")
	protected String myPage(){
		return "home";
	}
}
