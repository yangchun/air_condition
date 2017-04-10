package com.air_condition.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.air_condition.dao.Equipment_DataMapper;
import com.air_condition.service.EquipmentDataServiceI;
@Service
public class EquipmentDataServiceImpl implements EquipmentDataServiceI {

	@Autowired
	private Equipment_DataMapper equipmentdataDao;
	
	
	public List<Map<String, Object>> getAllEqData(int begin, int size) {
		// TODO Auto-generated method stub
		return equipmentdataDao.getAllEqData(begin, size);
	}

}
