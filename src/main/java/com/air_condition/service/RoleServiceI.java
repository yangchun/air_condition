package com.air_condition.service;
import java.util.*;
public interface RoleServiceI {
	
	public List<Map<String,Object>> getAllRolesName();
	public List<Map<String,Object>> getAllRolesList();
	public int delRoleById(int id);
 
}
