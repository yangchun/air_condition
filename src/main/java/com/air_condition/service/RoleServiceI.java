package com.air_condition.service;
import java.util.*;

import com.air_condition.domain.Role;
public interface RoleServiceI {
	
	public List<Map<String,Object>> getAllRolesName();
	public List<Map<String,Object>> getAllRolesList();
	public int delRoleById(int id);
	public int updateRoleInfo(Role role,Integer roleid,List<Integer> limits);
 
}
