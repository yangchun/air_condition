package com.air_condition.dao;

import com.air_condition.domain.Equipment_Data;
import java.util.*;
public interface Equipment_DataMapper {
    int insert(Equipment_Data record);

    int insertSelective(Equipment_Data record);
    
	List<Map<String, Object>> getAllEqData(int begin, int size);
}