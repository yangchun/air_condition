package com.air_condition.dao;

import com.air_condition.domain.Role_Limit;

public interface Role_LimitMapper {
    int insert(Role_Limit record);

    int insertSelective(Role_Limit record);
}