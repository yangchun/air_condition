package com.air_condition.controller;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.air_condition.domain.Warning_Config;
import com.air_condition.service.WarningConfigServiceI;
import com.util.CommonUtil;

@Controller
@RequestMapping("/warningconfig")
public class WarningConfigController {
	@Autowired
	private WarningConfigServiceI warningconfigServices;
	
	@RequestMapping("/getAllWarning_Config")
	@ResponseBody
	public JSONObject getAllWarning_Config(){
		List<Map<String,Object>> warningconfigs=warningconfigServices.getAllWarning_Config();
		return CommonUtil.constructHtmlResponse(1, "ok", warningconfigs);
	}
	
	
	@RequestMapping("/updateWarning_configstate")
	@ResponseBody
	public JSONObject updateWarning_configstate(Integer eqid,Integer state){
		int n=warningconfigServices.updateWarning_configstate(eqid, state);
		if(n>0){
			return CommonUtil.constructHtmlResponse(1, "ok", null);
		}
		return CommonUtil.constructHtmlResponse(0, "fail", null);
	}
	
	@RequestMapping("/updateWarning_config")
	@ResponseBody
	public JSONObject updateWarning_config(Integer eqid,Long warningTemp,Long warningPower,Integer informUser,Integer state){
		Warning_Config warning_config=new Warning_Config();
		warning_config.setEqid(eqid);
		warning_config.setWarningTemp(warningTemp);
		warning_config.setWarningPower(warningPower);
		warning_config.setInformUser(informUser);
		warning_config.setState(state);
		int n=warningconfigServices.updateWarning_config(warning_config);
		if(n>0){
			return CommonUtil.constructHtmlResponse(1, "ok", null);
		}
		return CommonUtil.constructHtmlResponse(0, "fail", null);
	}
	
	@RequestMapping("/getWarning_configByEqId")
	@ResponseBody
	public JSONObject getWarning_configByEqId(Integer eqid){
		Map<String,Object> warning_config=warningconfigServices.getWarning_configByEqId(eqid);
		if(warning_config!=null){
			return CommonUtil.constructHtmlResponse(1, "ok", warning_config);
		}
		return CommonUtil.constructHtmlResponse(0, "fail", null);
	}
	
	
	
	
}
