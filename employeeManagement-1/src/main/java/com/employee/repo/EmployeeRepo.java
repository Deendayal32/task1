package com.employee.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	public Page<Employee> findAll(Pageable pageable); 
}
