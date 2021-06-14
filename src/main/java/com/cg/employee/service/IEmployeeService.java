package com.cg.employee.service;

import java.util.List;

import com.cg.employee.entity.Employee;
import com.cg.employee.exception.EmployeeException;
import com.cg.employee.exception.EmployeeNotFoundException;
import com.cg.employee.exception.ValidateException;

public interface IEmployeeService {
	public Employee addEmployee(Employee e) throws ValidateException, EmployeeException;
	public List<Employee>getEmployees() throws EmployeeNotFoundException;
	public Employee findByEmployeeCode(int empId) throws EmployeeNotFoundException;
	public void deleteEmpById(int empId) throws EmployeeNotFoundException;
	public Employee updateEmployee(Employee emp) throws EmployeeNotFoundException;
//	public Employee getDetailsByAll(String userName,String password,String role);
}
