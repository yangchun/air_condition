package com.air_condition.controller;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.air_condition.service.EventInformServiceI;
import com.util.CommonUtil;

@Controller
@RequestMapping("/eventinform")
public class EventInformController {
	
	@Autowired
	private EventInformServiceI eventinformService;
	
	@RequestMapping("/getAllEventInform")
	@ResponseBody
	public JSONObject getAllEventInform(@RequestParam(required = false) Integer page){
		if (page == null || page < 0) {
			page = 1;
		}
		int pageSize=10;
		List<Map<String,Object>> events=eventinformService.getAllEvent_Inform((page - 1)
				* pageSize, pageSize);
		return CommonUtil.constructHtmlResponse(1, "ok", events);
	}
	
	
	
	@RequestMapping("/dealEventInform")
	@ResponseBody
	public JSONObject dealEventInform(Integer id){
		int n=eventinformService.dealEventInform(id);
		if(n>0){
			return CommonUtil.constructHtmlResponse(1, "ok", null);
		}
		return CommonUtil.constructHtmlResponse(0, "fail", null);
	}
	
	

}
