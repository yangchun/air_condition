package com.air_condition.controller;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.air_condition.domain.Limit;
import com.air_condition.service.LimitServiceI;
import com.util.CommonUtil;

import java.util.*;
@Controller
@RequestMapping("/limit")
public class LimitController {
	
	@Autowired
	private LimitServiceI limitService;
	
	
	@RequestMapping("/getAllLimits")
	@ResponseBody
	public JSONObject getAllLimits(){
		List<Map<String,Object>> limits=limitService.getAllLimits();
		return CommonUtil.constructHtmlResponse(1, "ok", limits);
	}
	
	
	@RequestMapping("/updateLimitInfo")
	@ResponseBody
	public JSONObject updateLimitInfo(Integer id,String limitcode,String limitdesc,Integer state){
		Limit limit=new Limit();
		limit.setId(id);
		limit.setLimitcode(limitcode);
		limit.setState(state);
		limit.setLimitdesc(limitdesc);
		int n=limitService.updateLimitInfo(limit);
		if(n>0){
			return CommonUtil.constructHtmlResponse(1, "ok", null);
		}
		return CommonUtil.constructHtmlResponse(0, "fail", null);
	}
	
	
	
	@RequestMapping("/delLimitById")
	@ResponseBody
	public JSONObject delLimitById(Integer id){
		int n=limitService.delLimitById(id);
		if(n>0){
			return CommonUtil.constructHtmlResponse(1, "ok", null);
		}
		return CommonUtil.constructHtmlResponse(0, "fail", null);
		
	}
	
	
	@RequestMapping("/addNewLimit")
	@ResponseBody
	public JSONObject addNewLimit(String limitcode,String limitdesc){
		Limit limit=new Limit();
		limit.setLimitcode(limitcode);
		limit.setState(1);
		limit.setLimitdesc(limitdesc);
		int n=limitService.addNewLimit(limit);
		List<Map<String,Object>> limits=limitService.getAllLimits();
		Map<String,Object> mp=limits.get(limits.size()-1);
		if(n>0){
			return CommonUtil.constructHtmlResponse(1, "ok", mp.get("id"));
		}
		return CommonUtil.constructHtmlResponse(0, "fail", null);
	}
	

}
