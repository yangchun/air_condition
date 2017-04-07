package com.air_condition.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.air_condition.dao.UserMapper;
import com.air_condition.domain.User;
import com.air_condition.service.UserServiceI;
@Service
public class UserServiceImpl implements UserServiceI {
	@Autowired
	private UserMapper userMapper;
	
	
	public User selectByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}


	@Override
	public List<Map<String, Object>> getAllUser() {
		// TODO Auto-generated method stub
		return userMapper.getAllUser();
	}

}
