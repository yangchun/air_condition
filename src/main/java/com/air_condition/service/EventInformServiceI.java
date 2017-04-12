package com.air_condition.service;
import java.util.*;
public interface EventInformServiceI {
	public List<Map<String,Object>> getAllEvent_Inform(int begin,int size);
	public int dealEventInform(int id);
}
