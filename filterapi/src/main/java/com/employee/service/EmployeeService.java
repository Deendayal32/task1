package com.employee.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Component;

import com.employee.entity.Employee;
import com.employee.repo.EmployeeRepo;

@Component
public class EmployeeService {
	
	
	@Autowired
	private EmployeeRepo empRepo;
	public Page<Employee> findAllBy(String key,Pageable pageable)
	{
		return  (Page<Employee>) empRepo.findByDepartOrPositionOrPgLmt(key,pageable) ;
	}
	public Page<Employee> findAll(Pageable pageable)
	{
		return empRepo.findAll(pageable);
		
	}
}
