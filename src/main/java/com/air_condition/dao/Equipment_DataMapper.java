package com.air_condition.dao;

import com.air_condition.domain.Equipment_Data;

public interface Equipment_DataMapper {
    int insert(Equipment_Data record);

    int insertSelective(Equipment_Data record);
}