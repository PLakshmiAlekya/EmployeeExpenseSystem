package com.cg.employee.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.employee.constants.Constants;
import com.cg.employee.entity.Expense;

import com.cg.employee.exception.ExpenseNotFoundException;
import com.cg.employee.repository.IExpenseRepository;
import com.cg.employee.service.IExpenseService;

@Service
public class ExpenseService implements IExpenseService {
	@Autowired
	IExpenseRepository expRepository;

	@Override
	public Expense addExpense(Expense expense) throws ValidationException {
		validateExpense(expense);
		return expRepository.save(expense);
	}

	@Override
	public Expense updateExpense(Expense expense) throws ExpenseNotFoundException {
		Optional<Expense> exp = expRepository.findById(expense.getExpenseCode());
		if (exp.isPresent()) {
			expense.setExpenseDescription(expense.getExpenseDescription());
			expense.setExpenseType(expense.getExpenseType());
			Expense newExpense = expRepository.save(expense);
		} else {
			throw new ExpenseNotFoundException(Constants.EXPENSE_NOT_FOUND);
		}
		return null;
	}

	@Override
	public Expense deleteExpenseByCode(int expenseCode) throws ExpenseNotFoundException {
		Optional<Expense> exp = expRepository.findById(expenseCode);
		if (!exp.isPresent()) {
			throw new ExpenseNotFoundException(Constants.EXPENSE_NOT_FOUND);
		} else {
			expRepository.deleteById(expenseCode);
		}
		return null;
	}

	@Override
	public void deleteAllExpense() throws ExpenseNotFoundException {
		List<Expense> explist = expRepository.findAll();
		if (explist.isEmpty()) {
			throw new ExpenseNotFoundException(Constants.NO_EXPENSE_RECORDS_FOUND);
		} else {
			expRepository.deleteAll();
		}
	}

	@Override
	public Expense findByCode(int expenseCode) throws ExpenseNotFoundException {
		Optional<Expense> exp = expRepository.findById(expenseCode);
		if (exp.isPresent()) {
			return expRepository.findById(expenseCode).get();
		} else {
			throw new ExpenseNotFoundException(Constants.EXPENSE_NOT_FOUND);
		}

	}

	@Override
	public List<Expense> getAllExpenses() throws ExpenseNotFoundException {
		List<Expense> explist = expRepository.findAll();
		if (explist.isEmpty())
			throw new ExpenseNotFoundException(Constants.EXPENSE_NOT_FOUND);
	//	explist.sort((e1, e2) -> e1.getExpenseType().compareTo(e2.getExpenseType()));
		return explist;
	}

	@Override
	public List<Integer> getAllExpenseCode() throws ExpenseNotFoundException {
		List<Expense> explist = new ArrayList<Expense>();
		explist = expRepository.findAll();
		if (explist.isEmpty())
			throw new ExpenseNotFoundException(Constants.NO_EXPENSE_RECORDS_FOUND);
		List<Integer> expCodes = new ArrayList<Integer>();
		Iterator itr = explist.iterator();
		while (itr.hasNext()) {
			Expense e = (Expense) itr.next();
			expCodes.add(e.getExpenseCode());
		}
		return expCodes;
	}

	@Override

	public List<Expense> getExpenseByCode(int expenseCode) throws ExpenseNotFoundException {
		Optional<Expense> getByCode = expRepository.findById(expenseCode);
		List<Expense> getList = new ArrayList<Expense>();
		if (getByCode.isPresent()) {
			getList.add(getByCode.get());
		}
		return getList;
	}

	public boolean validateExpense(Expense expense) throws ValidationException {
		if (!expense.getExpenseDescription().matches(Constants.DESCRIPTION_PATTERN)) {
			throw new ValidationException(Constants.EXPENSE_DESCRIPTION_CANNOT_BE_EMPTY);
		}
		if (!expense.getExpenseType().matches(Constants.DESCRIPTION_PATTERN)) {
			throw new ValidationException(Constants.EXPENSE_TYPE_CANNOT_BE_EMPTY);
		}
		return true;
	}
}
