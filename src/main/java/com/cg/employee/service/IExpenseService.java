package com.cg.employee.service;

import java.util.List;

import javax.xml.bind.ValidationException;

import com.cg.employee.entity.Expense;
import com.cg.employee.exception.ExpenseNotFoundException;

public interface IExpenseService {
	public List<Integer> getAllExpenseCode() throws ExpenseNotFoundException;
	public Expense addExpense(Expense expense) throws ValidationException;
	public List<Expense> getAllExpenses() throws ExpenseNotFoundException;
	public List<Expense> getExpenseByCode(int expenseCode) throws ExpenseNotFoundException;
	public Expense updateExpense(Expense expense) throws ExpenseNotFoundException;//exception
	public Expense deleteExpenseByCode(int expenseCode) throws ExpenseNotFoundException;//exception
	public void deleteAllExpense() throws ExpenseNotFoundException;
	public Expense findByCode(int expenseCode) throws ExpenseNotFoundException;//exception
	
}
