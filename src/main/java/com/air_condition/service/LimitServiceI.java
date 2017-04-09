package com.air_condition.service;
import java.util.*;

import com.air_condition.domain.Limit;
public interface LimitServiceI {
	
	public List<Map<String,Object>> getAllLimits();
	
	public int updateLimitInfo(Limit limit);
	
	public int delLimitById(Integer id);
	
	public int addNewLimit(Limit limit);
	
	

}
