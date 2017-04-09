package com.air_condition.service;

import java.util.List;
import java.util.Map;

import com.air_condition.domain.User;

public interface UserServiceI {
	public User selectByPrimaryKey(int id);
	public List<Map<String,Object>> getAllUser();
	public User isLogin(String username,String password);
	public int addNewUser(User u);
	public int delUserById(int userid);
	public int updateUserInfo(User u);
}
