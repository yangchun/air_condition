package com.air_condition.dao;

import com.air_condition.domain.Role;
import java.util.*;
public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    public List<Map<String,Object>> getAllRolesName();
}