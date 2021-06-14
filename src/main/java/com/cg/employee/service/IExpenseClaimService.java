package com.cg.employee.service;

import java.util.List;

import com.cg.employee.entity.ExpenseClaim;
import com.cg.employee.exception.ExpenseClaimNotFoundException;

public interface IExpenseClaimService {
	public List<ExpenseClaim> getAllExpenseClaim() throws ExpenseClaimNotFoundException;	
	public ExpenseClaim addExpenseClaim (ExpenseClaim expenseClaim);
	public ExpenseClaim fetchExpenseClaimById(int expenseCodeID) throws ExpenseClaimNotFoundException;
	public ExpenseClaim updateExpenseClaim(ExpenseClaim expenseClaim) throws ExpenseClaimNotFoundException;
	public ExpenseClaim deleteExpenseClaimById(int id) throws ExpenseClaimNotFoundException;
//	public List<ExpenseClaim> getAllClaimsByEmployee(Employee emp);
}
