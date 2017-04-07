package com.air_condition.controller;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.air_condition.service.RoleServiceI;
import com.util.CommonUtil;
import java.util.*;
@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleServiceI roleService;
	
	
	@RequestMapping("/getAllRoles")
	@ResponseBody
	public JSONObject getAllRoles(){
		List<Map<String,Object>> roles=roleService.getAllRoles();
		return CommonUtil.constructHtmlResponse(1, "ok", roles);
	}
}
