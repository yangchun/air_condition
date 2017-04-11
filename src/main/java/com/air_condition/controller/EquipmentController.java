package com.air_condition.controller;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.air_condition.domain.Equipment;
import com.air_condition.service.EquipmentServiceI;
import com.util.CommonUtil;

import java.util.*;
@Controller
@RequestMapping("/equipment")
public class EquipmentController {
	@Autowired
	private EquipmentServiceI equipmentService;
	
	@RequestMapping("/getAllEqs")
	@ResponseBody
	public JSONObject getAllEqs(){
		List<Map<String,Object>> eqs=equipmentService.getAllEqs();
		return CommonUtil.constructHtmlResponse(1, "ok", eqs);
	}
	
	
	
	@RequestMapping("/addNewEq")
	@ResponseBody
	public JSONObject addNewEq(String eqname,String eqtype){
		Equipment eq=new Equipment();
		eq.setEqname(eqname);
		eq.setEqtype(eqtype);
		Date eqbuytime=new Date();
		eq.setEqbuytime(eqbuytime);
		eq.setState(1);
		int n=equipmentService.addNewEq(eq);
		if(n>0){
			return CommonUtil.constructHtmlResponse(1, "ok", null);
		}
		return CommonUtil.constructHtmlResponse(0, "fail", null);
	}
	
	
	
	@RequestMapping("/delEqById")
	@ResponseBody
	public JSONObject delEqById(int eqid){
		int n=equipmentService.delEqById(eqid);
		if(n>0){
			return CommonUtil.constructHtmlResponse(1, "ok", null);
		}
		return CommonUtil.constructHtmlResponse(0, "fail", null);
	}
	
	@RequestMapping("/updateEqInfo")
	@ResponseBody
	public JSONObject updateEqInfo(Integer eqid,String eqname,String eqtype){
		Equipment eq=new Equipment();
		eq.setId(eqid);
		eq.setEqname(eqname);
		eq.setEqtype(eqtype);
		int n=equipmentService.updateEqInfo(eq);
		if(n>0){
			return CommonUtil.constructHtmlResponse(1, "ok", null);
		}
		return CommonUtil.constructHtmlResponse(0, "fail", null);
	} 
	
	@RequestMapping("/getEqInfoByEqId")
	@ResponseBody
	public JSONObject getEqInfoByEqId(int eqid){
		Map<String,Object> eqinfo=equipmentService.getEqInfoByEqId(eqid);
		if(eqinfo!=null){
			return CommonUtil.constructHtmlResponse(1, "ok", eqinfo);
		}
		return CommonUtil.constructHtmlResponse(0, "fail", null);
	}
 	
}
