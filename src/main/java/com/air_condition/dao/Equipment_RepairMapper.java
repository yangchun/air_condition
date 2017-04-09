package com.air_condition.dao;

import com.air_condition.domain.Equipment_Repair;

public interface Equipment_RepairMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Equipment_Repair record);

    int insertSelective(Equipment_Repair record);

    Equipment_Repair selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Equipment_Repair record);

    int updateByPrimaryKey(Equipment_Repair record);
    
    int delEq_RepairByEqId(int eqid);
}