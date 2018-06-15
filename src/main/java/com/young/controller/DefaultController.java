package com.young.controller;

import com.alibaba.fastjson.JSONArray;
import com.young.model.Employee;
import com.young.service.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/rest/ssm")
public class DefaultController {
    private static final Logger logger = LogManager.getLogger(DefaultController.class);
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public void getEmployees(HttpServletResponse response) {
        logger.info("begin to query all employees");
        List<Employee> employees = employeeService.getAll();
        if (employees == null) {
            employees = new ArrayList<>();
        }
        try {
            response.getWriter().print(JSONArray.toJSON(employees));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public void createEmployee(@RequestBody Employee employee, HttpServletResponse response) {
        try {
            response.getWriter().print(JSONArray.toJSON(employeeService.saveEmp(employee)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE, consumes = "application/json")
    public void deleteEmployeeById(@PathVariable("id") int id, HttpServletResponse response) {
        try {
            response.getWriter().print(JSONArray.toJSON(employeeService.deleteEmp(id)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public void updateEmployee(@RequestBody Employee employee, HttpServletResponse response) {
        try {
            response.getWriter().print(JSONArray.toJSON(employeeService.updateEmp(employee)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET, consumes = "application/json")
    public void queryEmployeeById(@PathVariable("id") int id, HttpServletResponse response) {
        try {
            response.getWriter().print(JSONArray.toJSON(employeeService.getEmp(id)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
