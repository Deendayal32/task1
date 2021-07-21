package com.employee.repo;




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	@Query(value=" from Employee e where e.department =:key or e.position=:key")
	public Page<Employee> findByDepartOrPositionOrPgLmt(@Param("key")String key , Pageable pageable); 
}
