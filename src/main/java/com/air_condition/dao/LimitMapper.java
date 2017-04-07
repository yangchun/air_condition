package com.air_condition.dao;

import com.air_condition.domain.Limit;

public interface LimitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Limit record);

    int insertSelective(Limit record);

    Limit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Limit record);

    int updateByPrimaryKey(Limit record);
}