package com.air_condition.dao;

import com.air_condition.domain.Room;
import java.util.*;
public interface RoomMapper {
    int deleteByPrimaryKey(Integer roomNum);

    int insert(Room record);

    int insertSelective(Room record);

    Room selectByPrimaryKey(Integer roomNum);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);
    
    List<Map<String,Object>> getAllRooms();
}