package com.air_condition.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.air_condition.dao.LimitMapper;
import com.air_condition.dao.RoleMapper;
import com.air_condition.dao.Role_LimitMapper;
import com.air_condition.service.RoleServiceI;
@Service
public class RoleServiceImpl implements RoleServiceI {
	
	
	@Autowired
	private RoleMapper roleDao;
	@Autowired
	private LimitMapper limitDao;
	@Autowired
	private Role_LimitMapper role_limitDao;
	

	public List<Map<String, Object>> getAllRolesName() {
		// TODO Auto-generated method stub
		return roleDao.getAllRolesName();
	}

	public List<Map<String, Object>> getAllRolesList() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> roles=roleDao.getAllRolesList();
		for(Map<String,Object> mp:roles){
			Integer id=(Integer) mp.get("id");
			List<Map<String, Object>> rolelimits=limitDao.getLimitsByRoleId(id);
			mp.put("limits", rolelimits);
		}
		return roles;
	}
	
	
	

	@Override
	public int delRoleById(int id) {
		// TODO Auto-generated method stub
		int n=0;
		try{
			roleDao.deleteByPrimaryKey(id);
			role_limitDao.delRoleLimitByRoleId(id);
			n=1;
		}catch(Exception e){
			return 0;
		}
		return n;
	}

}
