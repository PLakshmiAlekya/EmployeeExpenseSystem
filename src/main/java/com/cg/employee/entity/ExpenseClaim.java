package com.cg.employee.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ExpenseClaim {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int expenseCodeId;
	private double expenseAmount;
	private LocalDate startDate;
	private LocalDate endDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "ExpenseId",referencedColumnName = "expenseCode")
	private Expense expense;   //many claim one expense 
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ProjectId", referencedColumnName = "projectCode")
	private Project project;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "EmployeeId", referencedColumnName = "empId")
	private Employee employee;
	
	public ExpenseClaim() {
		super();
	}

	

	public ExpenseClaim(double expenseAmount, LocalDate startDate, LocalDate endDate, Expense expense, Project project,
			Employee employee) {
		super();
		this.expenseAmount = expenseAmount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.expense = expense;
		this.project = project;
		this.employee = employee;
	}



	public int getExpenseCodeId() {
		return expenseCodeId;
	}

	public void setExpenseCodeId(int expenseCodeId) {
		this.expenseCodeId = expenseCodeId;
	}

	public double getExpenseAmount() {
		return expenseAmount;
	}

	public void setExpenseAmount(double expenseAmount) {
		this.expenseAmount = expenseAmount;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Expense getExpense() {
		return expense;
	}

	public void setExpense(Expense expense) {
		this.expense = expense;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "ExpenseClaim [expenseCodeId=" + expenseCodeId + ", expenseAmount=" + expenseAmount + ", startDate="
				+ startDate + ", endDate=" + endDate + ", expense=" + expense + ", project=" + project + ", employee="
				+ employee + "]";
	}
	

}
