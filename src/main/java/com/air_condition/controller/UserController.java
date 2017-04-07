package com.air_condition.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.air_condition.domain.User;
import com.air_condition.service.UserServiceI;
import com.util.CommonUtil;

import java.util.*;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserServiceI userService;
	
	@RequestMapping("/getAllUser")
	@ResponseBody
	public JSONObject getAllUser(HttpServletRequest request,HttpServletResponse response){
		List<Map<String,Object>> users=userService.getAllUser();
		return CommonUtil.constructHtmlResponse(1, "ok", users);
	}
	
	
}
