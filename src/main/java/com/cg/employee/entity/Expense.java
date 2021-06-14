package com.cg.employee.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int expenseCode;
	private String expenseType;
	private String expenseDescription;
	
	public Expense() {
		super();
	}

	

	public Expense(String expenseType, String expenseDescription) {
		super();
		this.expenseType = expenseType;
		this.expenseDescription = expenseDescription;
	}



	public int getExpenseCode() {
		return expenseCode;
	}

	public void setExpenseCode(int expenseCode) {
		this.expenseCode = expenseCode;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public String getExpenseDescription() {
		return expenseDescription;
	}

	public void setExpenseDescription(String expenseDescription) {
		this.expenseDescription = expenseDescription;
	}

	@Override
	public String toString() {
		return "Expense [expenseCode=" + expenseCode + ", expenseType=" + expenseType + ", expenseDescription="
				+ expenseDescription + "]";
	}	
	
	
}