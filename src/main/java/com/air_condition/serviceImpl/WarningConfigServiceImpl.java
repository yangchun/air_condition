package com.air_condition.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.air_condition.dao.Warning_ConfigMapper;
import com.air_condition.domain.Warning_Config;
import com.air_condition.service.WarningConfigServiceI;
@Service
public class WarningConfigServiceImpl implements WarningConfigServiceI {

	@Autowired
	private Warning_ConfigMapper warningconfigDao;
	public List<Map<String, Object>> getAllWarning_Config() {
		// TODO Auto-generated method stub
		return warningconfigDao.getAllWarning_Config();
	}
	public int updateWarning_configstate(int eqid, int state) {
		// TODO Auto-generated method stub
		return warningconfigDao.updateWarning_configstate(eqid, state);
	}
	public int updateWarning_config(Warning_Config warning_config) {
		// TODO Auto-generated method stub
		return warningconfigDao.updateWarning_config(warning_config);
	}
	public Map<String, Object> getWarning_configByEqId(int eqid) {
		// TODO Auto-generated method stub
		return warningconfigDao.getWarning_configByEqId(eqid);
	}

}
