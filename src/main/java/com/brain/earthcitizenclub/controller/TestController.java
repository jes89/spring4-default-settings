package com.brain.earthcitizenclub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

	
	@RequestMapping("/fileup")
	protected String fileup(){
		
		return "/test/fileup";
	}
}
