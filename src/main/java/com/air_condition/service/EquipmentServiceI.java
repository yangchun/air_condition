package com.air_condition.service;
import java.util.*;

import com.air_condition.domain.Equipment;
public interface EquipmentServiceI {
	
	public List<Map<String,Object>> getAllEqs(); 
	public int addNewEq(Equipment eq);
	public int updateEqInfo(Equipment eq);
	public int delEqById(int eqid);
	
	

}
