package com.air_condition.service;

import java.util.List;
import java.util.Map;

import com.air_condition.domain.User;

public interface UserServiceI {
	public User selectByPrimaryKey(int id);
	public List<Map<String,Object>> getAllUser();
	
}