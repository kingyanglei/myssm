package com.young.controller;

import com.young.model.Department;
import com.young.model.Msg;
import com.young.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 处理和部门有关的请求
 *
 * @author lfy
 */
@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	/**
	 * 返回所有的部门信息
	 */
	@RequestMapping("/dept/{id}")
	@ResponseBody
	public Msg getDept(@PathVariable("id") int id) {
		//查出的所有部门信息
		Department dept = departmentService.getDept(id);
		return Msg.success().add("dept", dept);
	}

}
