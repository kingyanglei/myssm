package com.young.mapper;

import com.young.model.Department;

public interface DepartmentMapper {

    int deleteByPrimaryKey(Integer deptId);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer deptId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}