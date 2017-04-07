package com.air_condition.dao;

import com.air_condition.domain.Warning_Config;

public interface Warning_ConfigMapper {
    int insert(Warning_Config record);

    int insertSelective(Warning_Config record);
}