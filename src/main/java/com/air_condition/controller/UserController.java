package com.air_condition.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import javax.servlet.http.HttpSession;

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
	
	@RequestMapping("/login")
	@ResponseBody
	public JSONObject login(HttpSession session,String username,String password){
		User u=userService.isLogin(username, password);
		if(u!=null){
			session.setAttribute("user", u);
			return CommonUtil.constructHtmlResponse(1, "ok", null);
		}
		return CommonUtil.constructHtmlResponse(0, "fail", null);
	}
	
	
	
	@RequestMapping("/addNewUser")
	@ResponseBody
	public JSONObject addNewUser(String username,String password,String realname,String email,Integer role_id){
		User u=new User();
		u.setUsername(username);
		u.setPassword(password);
		u.setRealname(realname);
		u.setEmail(email);
		u.setRoleId(role_id);
		u.setState(1);
		int n=userService.addNewUser(u);
		List<Map<String,Object>> users=userService.getAllUser();
		Map<String,Object> newUser=users.get(users.size()-1);
		if(n>0){
			return CommonUtil.constructHtmlResponse(1, "ok", newUser.get("id"));
		}
		return CommonUtil.constructHtmlResponse(0, "fail", null);
	}
	
	
	@RequestMapping("/delUserById")
	@ResponseBody
	public JSONObject delUserById(Integer userid){
		int n=userService.delUserById(userid);
		if(n>0){
			return CommonUtil.constructHtmlResponse(1, "ok", null);
		}
		return CommonUtil.constructHtmlResponse(0, "fail", null);
	}
	
	
	
	@RequestMapping("/updateUserInfo")
	@ResponseBody
	public JSONObject updateUserInfo(Integer userid,String username,String password,String realname,String email,Integer role_id,Integer state){
		User u=new User();
		u.setId(userid);
		u.setUsername(username);
		u.setPassword(password);
		u.setRealname(realname);
		u.setEmail(email);
		u.setRoleId(role_id);
		u.setState(state);
		int n=userService.updateUserInfo(u);
		if(n>0){
			return CommonUtil.constructHtmlResponse(1, "ok", null);
		}
		return CommonUtil.constructHtmlResponse(0, "fail", null);
	}
	
}
