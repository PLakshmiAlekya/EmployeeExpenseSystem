package com.cg.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.employee.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {


	@Query(value = "select count(user_name) from login_details where user_name =:userName", nativeQuery = true)
	int existsByUserName(@Param ("userName") String userName);
	
	@Query(value = "select count(emp_email_id) from employee where emp_email_id =:empEmailId", nativeQuery = true)
	int existsByEmail(@Param ("empEmailId") String empEmailId);

}
