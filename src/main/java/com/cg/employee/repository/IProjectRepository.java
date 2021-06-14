package com.cg.employee.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.employee.entity.Project;


public interface IProjectRepository extends JpaRepository<Project, Integer>{

}
