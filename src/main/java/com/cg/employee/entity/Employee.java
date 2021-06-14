package com.cg.employee.entity;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empId;
	private String empName;
	private String empPAN;
	private String empDesignation;
	private String empDomain;
	private String empDOJ;
	private String empDOB;
	private double empSalary;
	private String empEmailId;
//	private String userName;
//	private String password;
//	private String role;	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "LoginId",referencedColumnName = "id")
	private LoginDetails login;
	
	
	public Employee() {
		super();
	}

	public Employee(String empName, String empPAN, String empDesignation, String empDomain, String empDOJ,
			String empDOB, double empSalary, String empEmailId, LoginDetails login) {
		super();
		this.empName = empName;
		this.empPAN = empPAN;
		this.empDesignation = empDesignation;
		this.empDomain = empDomain;
		this.empDOJ = empDOJ;
		this.empDOB = empDOB;
		this.empSalary = empSalary;
		this.empEmailId = empEmailId;
		this.login = login;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPAN() {
		return empPAN;
	}

	public void setEmpPAN(String empPAN) {
		this.empPAN = empPAN;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public String getEmpDomain() {
		return empDomain;
	}

	public void setEmpDomain(String empDomain) {
		this.empDomain = empDomain;
	}

	public String getEmpDOJ() {
		return empDOJ;
	}

	public void setEmpDOJ(String empDOJ) {
		this.empDOJ = empDOJ;
	}

	public String getEmpDOB() {
		return empDOB;
	}

	public void setEmpDOB(String empDOB) {
		this.empDOB = empDOB;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	public String getEmpEmailId() {
		return empEmailId;
	}

	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}

	public LoginDetails getLogin() {
		return login;
	}

	public void setLogin(LoginDetails login) {
		this.login = login;
	}

}