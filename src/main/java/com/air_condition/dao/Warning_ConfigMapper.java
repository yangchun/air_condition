package com.air_condition.dao;

import com.air_condition.domain.Warning_Config;
import java.util.*;
public interface Warning_ConfigMapper {
    int insert(Warning_Config record);

    int insertSelective(Warning_Config record);
    
    List<Map<String,Object>> getAllWarning_Config();
    
    int updateWarning_configstate(int eqid,int state);
    
    int updateWarning_config(Warning_Config warning_config);
    
    
}