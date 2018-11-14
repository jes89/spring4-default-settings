package com.brain.earthcitizenclub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brain.jjan.mapper.EmotionMapper;

@RestController
@RequestMapping("/ajax")
public class AjaxController {
	
	@Autowired
	EmotionMapper emotionMapper;
	
	
	@RequestMapping(value = "/getEmotion", produces = "application/text; charset=utf8")
	protected String getEmotion(){
		return emotionMapper.selectReplyEmoticon().get("Json");
	}
}
