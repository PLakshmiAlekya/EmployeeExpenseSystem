package com.cg.employee.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.employee.constants.Constants;
import com.cg.employee.entity.Employee;
import com.cg.employee.exception.EmployeeException;
import com.cg.employee.exception.EmployeeNotFoundException;
import com.cg.employee.exception.ValidateException;
import com.cg.employee.repository.IEmployeeRepository;
import com.cg.employee.service.IEmployeeService;


@Service
public class EmployeeService implements IEmployeeService {
	
	@Autowired
	IEmployeeRepository empRepository;

	@Override
	public Employee addEmployee(Employee e) throws ValidateException, EmployeeException {
		validateEmployee(e);
		
		if(empRepository.existsByEmail(e.getEmpEmailId()) > 0) {
			throw new EmployeeException("Already user exists by this email id");
		}
		if(empRepository.existsByUserName(e.getLogin().getUserName()) > 0) {
			throw new EmployeeException("Already user exists with this user name");
		}
		empRepository.save(e);
		return null;
	}

	@Override
	public List<Employee> getEmployees() throws EmployeeNotFoundException {
		List<Employee> empList = empRepository.findAll();
		if (empList.isEmpty())
			throw new EmployeeNotFoundException(Constants.NO_EMPLOYEES);
	//	empList.sort((e1, e2) -> e1.getEmpEmailId().compareTo(e2.getEmpEmailId()));
		
		return empList;
	}

	@Override
	public Employee findByEmployeeCode(int empId) throws EmployeeNotFoundException {
		Optional<Employee> emp = empRepository.findById(empId);
		if (emp.isPresent()) {
			return empRepository.findById(empId).get();
		} else {
			throw new EmployeeNotFoundException(Constants.EMPLOYEE_DOES_NOT_EXISTS);
		}

	}

	@Override
	public void deleteEmpById(int empId) throws EmployeeNotFoundException {
		Optional<Employee> e = empRepository.findById(empId);
		if (e.isPresent()) {
			empRepository.deleteById(empId);
		} else {
			throw new EmployeeNotFoundException(Constants.EMPLOYEE_DOES_NOT_EXISTS);
		}
	}

	@Override
	public Employee updateEmployee(Employee emp) throws EmployeeNotFoundException {
		Optional<Employee> employee = empRepository.findById(emp.getEmpId());
		if (employee.isPresent()) {
			//Employee e = employee.get();
			emp.setEmpName(emp.getEmpName());
			emp.setEmpDesignation(emp.getEmpDesignation());
			emp.setEmpDOB(emp.getEmpDOB());
			emp.setEmpDOJ(emp.getEmpDOJ());
			emp.setEmpDomain(emp.getEmpDomain());
			emp.setEmpEmailId(emp.getEmpEmailId());
			emp.setEmpSalary(emp.getEmpSalary());
			Employee newEmp = empRepository.save(emp);
		} else {
			throw new EmployeeNotFoundException(Constants.EMPLOYEE_DOES_NOT_EXISTS);
		}
		return null;
	}
	
	public boolean validateEmployee(Employee e) throws ValidateException{
		if(!e.getEmpName().matches(Constants.NAME_PATTERN)) {
			throw new ValidateException(Constants.NAME_CANNOT_BE_EMPTY);
		}
		if(!e.getEmpEmailId().matches(Constants.EMAILID_PATTERN)) {
			throw new ValidateException(Constants.EMAIL_CANNOT_BE_EMPTY);
		}
		if(!e.getEmpPAN().matches(Constants.EMP_PAN_PATTERN)) {
			throw new ValidateException(Constants.PAN_CANNOT_BE_EMPTY);
		}
		if(!e.getEmpDesignation().matches(Constants.DESIGNATION_PATTERN)) {
			throw new ValidateException(Constants.DESIGNATION_CANNOT_BE_EMPTY);
		}
		if(!e.getEmpDomain().matches(Constants.DOMAIN_PATTERN)) {
			throw new ValidateException(Constants.DOMAIN_CANNOT_BE_EMPTY);
		}
		if(!e.getEmpDOB().matches(Constants.DATE_PATTERN)) {
			throw new ValidateException(Constants.INVALID_DATE_FORMAT);
		}
		if(!e.getEmpDOJ().matches(Constants.DATE_PATTERN)) {
			throw new ValidateException(Constants.INVALID_DATE_FORMAT);
		}
		String salString = Double.toString(e.getEmpSalary());
		if(!salString.matches(Constants.SALARY_PATTERN)) {
			throw new ValidateException(Constants.INVALID_DATE_FORMAT);
		}
		if (!e.getLogin().getUserName().matches(Constants.USERNAME_PATTERN)) {
			throw new ValidateException(Constants.NAME_CANNOT_BE_EMPTY);
		}
		if (!e.getLogin().getPassword().matches(Constants.PASSWORD_PATTERN)) {
			throw new ValidateException(Constants.PASSWORD_CANNOT_BE_EMPTY);
		}
		if (!e.getLogin().getRole().matches(Constants.ROLE_PATTERN)) {
			throw new ValidateException(Constants.ROLE_CANNOT_BE_EMPTY);
		}
		return true;	
}
}