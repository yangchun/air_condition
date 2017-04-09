package com.air_condition.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.air_condition.dao.EquipmentMapper;
import com.air_condition.dao.Equipment_RepairMapper;
import com.air_condition.dao.Warning_ConfigMapper;
import com.air_condition.domain.Equipment;
import com.air_condition.service.EquipmentServiceI;
@Service
public class EquipmentServiceImpl implements EquipmentServiceI {
	
	
	@Autowired
	private EquipmentMapper equipmentDao;
	@Autowired
	private Equipment_RepairMapper equipment_repairDao; 
	
	public List<Map<String, Object>> getAllEqs() {
		// TODO Auto-generated method stub
		return equipmentDao.getAllEqs();
	}

	public int addNewEq(Equipment eq) {
		// TODO Auto-generated method stub
		return equipmentDao.insertSelective(eq);
	}

	public int delEqById(int eqid) {
		// TODO Auto-generated method stub
		int n=0;
		try{
			equipmentDao.deleteByPrimaryKey(eqid);
			equipment_repairDao.delEq_RepairByEqId(eqid);
			n=1;
		}catch(Exception e){
			return 0;
		}
		return n;
	}

	public int updateEqInfo(Equipment eq) {
		// TODO Auto-generated method stub
		return equipmentDao.updateByPrimaryKeySelective(eq);
	}


}
