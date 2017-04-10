package com.air_condition.controller;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.air_condition.service.EquipmentDataServiceI;
import com.util.CommonUtil;

@Controller
@RequestMapping("/equipmentdata")
public class EquipmentDataController {

	@Autowired
	private EquipmentDataServiceI equipmentdataService;
	
	@RequestMapping("getAllEqData")
	@ResponseBody 
	public JSONObject getAllEqData(@RequestParam(required = false) Integer page) {
		if (page == null || page < 0) {
			page = 1;
		}
		int pageSize=10;
		List<Map<String, Object>> eqdatas = equipmentdataService.getAllEqData((page - 1)
				* pageSize, pageSize);
		return CommonUtil.constructHtmlResponse(1,"ok",eqdatas);
	}
	
}
