package com.air_condition.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.air_condition.dao.Event_InformMapper;
import com.air_condition.service.EventInformServiceI;
@Service
public class EventInformServiceImpl implements EventInformServiceI {
	
	@Autowired
	private Event_InformMapper eventinformDao;
	
	public List<Map<String, Object>> getAllEvent_Inform() {
		// TODO Auto-generated method stub
		return eventinformDao.getAllEvent_Inform();
	}

	public int dealEventInform(int id) {
		// TODO Auto-generated method stub
		return eventinformDao.dealEventInform(id);
	}

}
