package com.air_condition.dao;

import com.air_condition.domain.User;
import java.util.*;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<Map<String,Object>> getAllUser();
}