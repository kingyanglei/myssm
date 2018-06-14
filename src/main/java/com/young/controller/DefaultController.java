package com.young.controller;

import com.alibaba.fastjson.JSONArray;
import com.young.model.Employee;
import com.young.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/rest/ssm")
public class DefaultController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public void getEmployees(HttpServletResponse response) {
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

}
