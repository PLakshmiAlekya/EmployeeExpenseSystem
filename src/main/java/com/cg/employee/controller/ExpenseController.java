package com.cg.employee.controller;

import java.util.List;

import javax.xml.bind.ValidationException;

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
import com.cg.employee.entity.Expense;
import com.cg.employee.exception.ExpenseNotFoundException;
import com.cg.employee.serviceImpl.ExpenseService;

@RestController
public class ExpenseController {

	@Autowired
	ExpenseService expService;

	// working
//	@PostMapping("/addExpense")
//	public Expense addExpense(@RequestBody Expense expense) {
//		return expService.addExpense(expense);
//	}
	// working
//	@DeleteMapping("/deleteExpense/{id}")
//	public Expense deleteExpenseByCode(@PathVariable("id") int expenseCode) throws ExpenseNotFoundException {
//		return expService.deleteExpenseByCode(expenseCode);
//	}

	// working
	@PostMapping("/addExpense")
	public SuccessMessage addExpense(@RequestBody Expense expense) throws ValidationException {
		expService.addExpense(expense);
		return new SuccessMessage(Constants.EXPENSE_ADDED);
	}

	// working
	@GetMapping("/findExpense/{id}")
	public Expense findByCode(@PathVariable("id") int expenseCode) throws ExpenseNotFoundException {
		return expService.findByCode(expenseCode);
	}

	// working
	@DeleteMapping("/deleteExpense/{id}")
	public SuccessMessage deleteExpenseByCode(@PathVariable("id") int expenseCode) throws ExpenseNotFoundException {
		expService.deleteExpenseByCode(expenseCode);
		return new SuccessMessage(Constants.EXPENSE_DELETED);
	}

	// working
	@PutMapping("/updateExpense")
	public SuccessMessage updateExpense(@RequestBody Expense expense) throws ExpenseNotFoundException {
		expService.updateExpense(expense);
		return new SuccessMessage(Constants.EXPENSE_UPDATED);
	}

	// working
	@DeleteMapping("/deleteAllExpenses")
	public SuccessMessage deleteAllExpense() throws ExpenseNotFoundException {
		expService.deleteAllExpense();
		return new SuccessMessage(Constants.DELETE_ALLEXPENSES);
	}
	
	//working
	@GetMapping("/getAllExpenses")
	public List<Expense> getAllExpenses() throws ExpenseNotFoundException{
		return expService.getAllExpenses();
		
	}
	
	///working
	@GetMapping("/getAllExpenseCodes")
	public List<Integer> getAllExpenseCode() throws ExpenseNotFoundException{
		return expService.getAllExpenseCode();
		
	}
	// working
	@GetMapping("/getExpense/{id}")
	public List<Expense> getExpenseByCode(@PathVariable  ("id") int expenseCode) throws ExpenseNotFoundException {
		return expService.getExpenseByCode(expenseCode);
	}
}

