package com.young.mapper;

import com.young.model.Employee;

import java.util.List;

public interface EmployeeMapper {

    int insert(Employee record);

    void insertSelective(Employee employee);

    int deleteByPrimaryKey(Integer empId);

    Employee selectByPrimaryKey(Integer empId);

    Employee selectByPrimaryKeyWithDept(Integer empId);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    List<Employee> selectByExampleWithDept();
}