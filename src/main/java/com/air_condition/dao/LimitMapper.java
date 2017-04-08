package com.air_condition.dao;

import java.util.List;
import java.util.Map;

import com.air_condition.domain.Limit;

public interface LimitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Limit record);

    int insertSelective(Limit record);

    Limit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Limit record);

    int updateByPrimaryKey(Limit record);
    
    List<Map<String,Object>> getAllLimits();
    
    List<Map<String,Object>> getLimitsByRoleId(int id);
    
    
	
}