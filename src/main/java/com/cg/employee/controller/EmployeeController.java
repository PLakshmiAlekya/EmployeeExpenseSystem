package com.cg.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.employee.constants.Constants;
import com.cg.employee.dto.SuccessMessage;
import com.cg.employee.entity.Employee;
import com.cg.employee.exception.EmployeeException;
import com.cg.employee.exception.EmployeeNotFoundException;
import com.cg.employee.exception.ValidateException;
import com.cg.employee.serviceImpl.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	//working
	@PostMapping("/addEmployee")
	public SuccessMessage addEmployee(@RequestBody Employee e) throws ValidateException, EmployeeException {
		empService.addEmployee(e);
		return new SuccessMessage(Constants.EMPLOYEE_ADDED);
	}
	
	//working
	@GetMapping("/getEmployee/{id}")
	public Employee findByEmployeeCode(@PathVariable("id") int empId) throws EmployeeNotFoundException {
		return empService.findByEmployeeCode(empId);
		
	}
	//working
	@DeleteMapping("/deleteEmployee/{id}")
	public SuccessMessage deleteEmpById(@PathVariable("id") int empId) throws EmployeeNotFoundException {
		empService.deleteEmpById(empId);
		return new SuccessMessage(Constants.EMPLOYEE_DELETED);
		
	}
	//working
	@PutMapping("/updateEmployee")
	public SuccessMessage updateEmployee(@RequestBody Employee emp) throws EmployeeNotFoundException {
		empService.updateEmployee(emp);
		return new SuccessMessage(Constants.EMPLOYEE_UPDATED);
	}

	//working
	@GetMapping("/getAllEmployees")
	public List<Employee> getEmployees() throws EmployeeNotFoundException {
		return empService.getEmployees();
	}
	
//	@GetMapping("/getDetails")
//	public Employee getDetailsByAll(String userName, String password, String role) {
//		return null;
//	}
}
