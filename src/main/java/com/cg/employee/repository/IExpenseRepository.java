package com.cg.employee.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.employee.entity.Expense;


public interface IExpenseRepository extends JpaRepository<Expense, Integer>{
}
