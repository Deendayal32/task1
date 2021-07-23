package com.employee.controller;



import java.util.List;

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
	public Page<Employee> SearchEmployee(@RequestParam  String key) 
	{
		Integer a=null;
		Pageable pageable=null;
		try {
			 a=Integer.parseInt(key);
		}catch(Exception e) {e.printStackTrace();}
		if(a!=null) {
		 pageable = PageRequest.of(0, a);
		return (Page<Employee>) empServ.findAll(pageable);
		}else {
		return (Page<Employee>) empServ.findAllBy(key,pageable) ;
		}
	}
	
}
