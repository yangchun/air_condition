package com.air_condition.controller;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.air_condition.domain.Role;
import com.air_condition.service.RoleServiceI;
import com.util.CommonUtil;

import java.util.*;
@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleServiceI roleService;
	
	
	
	@RequestMapping("/getAllRolesName")
	@ResponseBody
	public JSONObject getAllRolesName(){
		List<Map<String,Object>> roles=roleService.getAllRolesName();
		return CommonUtil.constructHtmlResponse(1, "ok", roles);
	}
	
	
	@RequestMapping("/getAllRolesList")
	@ResponseBody
	public JSONObject getAllRolesList(){
		List<Map<String,Object>> roles=roleService.getAllRolesList();
		return CommonUtil.constructHtmlResponse(1, "ok", roles);
	}
	
	
	@RequestMapping("/delRoleById")
	@ResponseBody
	public JSONObject delRoleById(Integer roleid){
		int n=roleService.delRoleById(roleid);
		if(n>0){
			return CommonUtil.constructHtmlResponse(1, "ok", null);
		}
		return CommonUtil.constructHtmlResponse(0, "fail", null);
	}
	
	
	@RequestMapping("/addNewRole")
	@ResponseBody
	public JSONObject addNewRole(String  rolename){
		
		
		
		return null;
	}
	
	@RequestMapping("/updateRoleInfo")
	@ResponseBody
	public JSONObject updateRoleInfo(Integer id,String rolename,String roledesc,@RequestBody List<Integer> limits,Integer state){
		Role r=new Role();
		r.setId(id);
		r.setRolename(rolename);
		r.setRoledesc(roledesc);
		r.setState(state);
		int n=roleService.updateRoleInfo(r, id, limits);
		if(n>0){
			return CommonUtil.constructHtmlResponse(1, "ok", null);
		}
		return CommonUtil.constructHtmlResponse(0, "fail", null);
	}
	
}
