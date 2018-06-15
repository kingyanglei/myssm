package com.young.service;

import com.young.controller.DefaultController;
import com.young.mapper.EmployeeMapper;
import com.young.model.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private static final Logger logger = LogManager.getLogger(EmployeeService.class);
    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 查询所有员工
     *
     * @return
     */
    public List<Employee> getAll() {
        logger.info("start to execute employeeService getAll");
        return employeeMapper.selectByExampleWithDept();
    }

    /**
     * 员工保存
     *
     * @param employee
     */
    public Employee saveEmp(Employee employee) {
        employeeMapper.insertSelective(employee);
        int empId = employee.getEmpId();
        return employee.getdId() == 0 ? employeeMapper.selectByPrimaryKey(empId) : employeeMapper.selectByPrimaryKeyWithDept(empId);
    }

    /**
     * 按照员工id查询员工
     *
     * @param id
     * @return
     */
    public Employee getEmp(Integer id) {
        return employeeMapper.selectByPrimaryKeyWithDept(id);
    }

    /**
     * 员工更新
     *
     * @param employee
     */
    public Employee updateEmp(Employee employee) {
        employeeMapper.updateByPrimaryKeySelective(employee);
        return employeeMapper.selectByPrimaryKeyWithDept(employee.getEmpId());
    }

    /**
     * 员工删除
     *
     * @param id
     */
    public Employee deleteEmp(Integer id) {
        Employee employee = employeeMapper.selectByPrimaryKeyWithDept(id);
        employeeMapper.deleteByPrimaryKey(id);
        return employee;
    }
}
