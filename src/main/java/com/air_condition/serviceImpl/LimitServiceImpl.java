package com.air_condition.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.air_condition.dao.LimitMapper;
import com.air_condition.domain.Limit;
import com.air_condition.service.LimitServiceI;
@Service
public class LimitServiceImpl implements LimitServiceI {

	@Autowired
	private LimitMapper limitMapper;
	
	
	public List<Map<String, Object>> getAllLimits() {
		// TODO Auto-generated method stub
		return limitMapper.getAllLimits();
	}

	public int updateLimitInfo(Limit limit) {
		// TODO Auto-generated method stub
		return limitMapper.updateByPrimaryKeySelective(limit);
	}

	public int delLimitById(Integer id) {
		// TODO Auto-generated method stub
		return limitMapper.deleteByPrimaryKey(id);
	}

	public int addNewLimit(Limit limit) {
		// TODO Auto-generated method stub
		return limitMapper.insertSelective(limit);
	}

}
