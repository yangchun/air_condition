package com.air_condition.controller;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.air_condition.domain.Room;
import com.air_condition.service.RoomServiceI;
import com.util.CommonUtil;

import java.util.*;
@Controller
@RequestMapping("/room")
public class RoomController {
	
	@Autowired
	private RoomServiceI roomService;
	
	@RequestMapping("/getAllRooms")
	@ResponseBody
	public JSONObject getAllRooms(){
		List<Map<String,Object>> rooms=roomService.getAllRooms();
		return CommonUtil.constructHtmlResponse(1, "ok", rooms);
	}
	
	@RequestMapping("/addNewRoom")
	@ResponseBody
	public JSONObject addNewRoom(Integer room_num,String temp,String humidity,String type,Double air_speed,int state){
		Room room=new Room();
		room.setRoomNum(room_num);
		room.setTemp(temp);
		room.setHumidity(humidity);
		room.setAirSpeed(air_speed);
		room.setType(type);
		room.setState(1);
		int n=roomService.addNewRoom(room);
		if(n>0){
			return CommonUtil.constructHtmlResponse(1, "ok", null);
		}
		return CommonUtil.constructHtmlResponse(0, "fail", null);
	}
	
	@RequestMapping("/updateRoomInfo")
	@ResponseBody
	public JSONObject updateRoomInfo(Integer room_num,String temp,String humidity,String type,Double air_speed,int state){
		Room room=new Room();
		room.setRoomNum(room_num);
		room.setTemp(temp);
		room.setHumidity(humidity);
		room.setAirSpeed(air_speed);
		room.setType(type);
		room.setState(state);
		int n=roomService.updateRoomInfo(room);
		if(n>0){
			return CommonUtil.constructHtmlResponse(1, "ok", null);
		}
		return CommonUtil.constructHtmlResponse(0, "fail", null);
	}
	
	@RequestMapping("/delRoomById")
	@ResponseBody
	public JSONObject delRoomById(int room_num){
		
		int n=roomService.delRoomById(room_num);
		if(n>0){
			return CommonUtil.constructHtmlResponse(1, "ok", null);
		}
		return CommonUtil.constructHtmlResponse(0, "fail", null);
	}
	
	@RequestMapping("/closeRoom")
	@ResponseBody
	public JSONObject closeRoom(int room_num){
		Room room=new Room();
		room.setRoomNum(room_num);
		room.setTemp("0");
		room.setHumidity("0");
		room.setAirSpeed(Double.valueOf("0"));
		room.setType("ÖÆÀä");
		room.setState(0);
		int n=roomService.updateRoomInfo(room);
		if(n>0){
			return CommonUtil.constructHtmlResponse(1, "ok", null);
		}
		return CommonUtil.constructHtmlResponse(0, "fail", null);
		
	}
	
	
	
	
	

}
