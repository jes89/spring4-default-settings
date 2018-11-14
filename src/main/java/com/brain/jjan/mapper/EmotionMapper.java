package com.brain.jjan.mapper;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Mapper;

import com.brain.earthcitizenclub.dto.UserDTO;

public interface EmotionMapper {
	public HashMap<String, String> selectReplyEmoticon();
}
