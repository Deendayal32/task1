package com.employee.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empServ;
	@RequestMapping("/")
	public Page<Employee> hello(@RequestParam int record) 
	{
		Pageable pageable = PageRequest.of(0, record); 
		return empServ.findAll(pageable) ;
	}
	
}
