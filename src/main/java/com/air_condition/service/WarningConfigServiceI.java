package com.air_condition.service;

import java.util.List;
import java.util.Map;

import com.air_condition.domain.Warning_Config;

public interface WarningConfigServiceI {
	 List<Map<String,Object>> getAllWarning_Config();
	 int updateWarning_configstate(int eqid,int state);
	 int updateWarning_config(Warning_Config warning_config);
}
