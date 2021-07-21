package com.employee.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.employee.entity.Employe;

public interface EmployeRepo extends CrudRepository<Employe,Integer>{

	@Query(value= "from Employe  e where e.eid=:ids")
	public Employe findByEid(@Param("ids")int ids);
	
}
