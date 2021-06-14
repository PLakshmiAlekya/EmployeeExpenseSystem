package com.cg.employee.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.employee.entity.ExpenseClaim;


public interface IExpenseClaimRepository extends JpaRepository<ExpenseClaim, Integer>{

}
