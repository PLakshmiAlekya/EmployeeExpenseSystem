package com.cg.employee.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.employee.constants.Constants;
import com.cg.employee.entity.ExpenseClaim;
import com.cg.employee.exception.ExpenseClaimNotFoundException;
import com.cg.employee.exception.ValidateException;
import com.cg.employee.repository.IExpenseClaimRepository;
import com.cg.employee.service.IExpenseClaimService;

@Service
public class ExpenseClaimService implements IExpenseClaimService {
	@Autowired
	IExpenseClaimRepository expClaimRepositrory;
	
	

	@Override
	public List<ExpenseClaim> getAllExpenseClaim() throws ExpenseClaimNotFoundException {
		List<ExpenseClaim> explist = expClaimRepositrory.findAll();
		if(explist.isEmpty())
			throw new ExpenseClaimNotFoundException(Constants.NO_EXPENSECLAIMS);
		return explist;
	}

	@Override
	public ExpenseClaim addExpenseClaim(ExpenseClaim expenseClaim) {
		return expClaimRepositrory.save(expenseClaim);
	}

	@Override
	public ExpenseClaim fetchExpenseClaimById(int id) throws ExpenseClaimNotFoundException {
		ExpenseClaim e = new ExpenseClaim();
		id = e.getExpenseCodeId();
		Optional<ExpenseClaim> ec = expClaimRepositrory.findById(id);
		if(!ec.isPresent()) {
			throw new ExpenseClaimNotFoundException(Constants.EXPENSECLAIM_NOT_FOUND);
		}else {			
			expClaimRepositrory.findById(id).get();
		}
		return null;
	}

	@Override
	public ExpenseClaim updateExpenseClaim(ExpenseClaim expenseClaim) throws ExpenseClaimNotFoundException {
		Optional<ExpenseClaim> ec = expClaimRepositrory.findById(expenseClaim.getExpenseCodeId());
		if(!ec.isPresent()) {
			ExpenseClaim e = ec.get();
			expenseClaim.setExpenseAmount(e.getExpenseAmount());
			expenseClaim.setStartDate(e.getStartDate());
			expenseClaim.setEndDate(e.getEndDate());
			ExpenseClaim newExpClaim = expClaimRepositrory.save(expenseClaim);					
		} else {
			throw new ExpenseClaimNotFoundException(Constants.EXPENSE_NOT_FOUND);
		}
		return expenseClaim;
	}
		

	@Override
	public ExpenseClaim deleteExpenseClaimById(int expenseCodeID) throws ExpenseClaimNotFoundException {
		Optional<ExpenseClaim> ec = expClaimRepositrory.findById(expenseCodeID);
		if(!ec.isPresent()) {
			throw new ExpenseClaimNotFoundException(Constants.EXPENSECLAIM_NOT_FOUND);
		}else {
			ExpenseClaim expc = ec.get();
			expClaimRepositrory.delete(expc);
		}
		return null;	
	}
	
	
	public boolean ValidateExpenseClaim(ExpenseClaim expClaim) throws ValidateException{
		if(!(expClaim.getStartDate().isBefore(expClaim.getEndDate()))) {
			throw new ValidateException(Constants.WRONG_DATE_INPUT);
		}
		else {
			return false;
		}
			}
		 

//	@Override
//	public List<ExpenseClaim> getAllClaimsByEmployee(Employee emp) {
//
//		return null;
//	}

}
