package com.air_condition.dao;

import com.air_condition.domain.Equipment;
import java.util.*;
public interface EquipmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Equipment record);

    int insertSelective(Equipment record);

    Equipment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Equipment record);

    int updateByPrimaryKey(Equipment record);
    
    List<Map<String,Object>> getAllEqs();
    
    Map<String,Object> getEqInfoByEqId(int eqid);
}