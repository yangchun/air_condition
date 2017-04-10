package com.air_condition.service;

import java.util.List;
import java.util.Map;

public interface EquipmentDataServiceI {
	List<Map<String, Object>> getAllEqData(int begin, int size);
}
