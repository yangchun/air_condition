package com.air_condition.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.air_condition.dao.RoleMapper;
import com.air_condition.dao.Role_LimitMapper;
import com.air_condition.service.RoleServiceI;
@Service
public class RoleServiceImpl implements RoleServiceI {
	
	
	@Autowired
	private RoleMapper roleDao;

	public List<Map<String, Object>> getAllRoles() {
		// TODO Auto-generated method stub
		return roleDao.getAllRoles();
	}

}
