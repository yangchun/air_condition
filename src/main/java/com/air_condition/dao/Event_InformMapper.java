package com.air_condition.dao;

import com.air_condition.domain.Event_Inform;

public interface Event_InformMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Event_Inform record);

    int insertSelective(Event_Inform record);

    Event_Inform selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Event_Inform record);

    int updateByPrimaryKey(Event_Inform record);
}