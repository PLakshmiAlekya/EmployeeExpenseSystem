package com.cg.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.employee.entity.ExpenseClaim;
import com.cg.employee.exception.ExpenseClaimNotFoundException;
import com.cg.employee.serviceImpl.ExpenseClaimService;


@RestController
public class ExpenseClaimController {
	
	@Autowired
	ExpenseClaimService expClaimService;
		
	@PostMapping("/addExpenseClaim")
	public ExpenseClaim addExpenseClaim (@RequestBody ExpenseClaim expenseClaim) {
		return expClaimService.addExpenseClaim(expenseClaim);
	}
	
	@GetMapping("/getExpenseClaim/{id}")
	public ExpenseClaim fetchExpenseClaimById(@PathVariable("id") int expenseCodeID) throws ExpenseClaimNotFoundException{
		return expClaimService.fetchExpenseClaimById(expenseCodeID);
	}
	
	@PutMapping("/updateClaim")
	public ExpenseClaim updateExpenseClaim(@RequestBody ExpenseClaim expenseClaim) throws ExpenseClaimNotFoundException{
		return expClaimService.updateExpenseClaim(expenseClaim);
	}
	
	@DeleteMapping("/deleteClaim/{id}")
	public ExpenseClaim deleteExpenseClaimById(int id) throws ExpenseClaimNotFoundException{
		return expClaimService.deleteExpenseClaimById(id);
	}
	
//	@PostMapping("/addExpenseClaim")
//	public SuccessMessage addExpenseClaim (@RequestBody ExpenseClaim expenseClaim) {
//		return new SuccessMessage(Constants.EXPENSE_ADDED);
//	}
	
//	
//	
//	@PutMapping("/updateExpenseClaim")
//	public SuccessMessage updateExpenseClaim(@RequestBody ExpenseClaim expenseClaim) throws ExpenseClaimNotFoundException{
//		return new SuccessMessage(Constants.EXPENSE_UPDATED);
//	}
//	
//	@DeleteMapping("/deleteExpenseClaim/{id}")
//	public SuccessMessage deleteExpenseClaimById(int id) throws ExpenseClaimNotFoundException{
//		return new SuccessMessage(Constants.EXPENSE_DELETED);
//	}
//	
	
	

}
