package com.cg.employee.service;

import java.util.List;

import javax.xml.bind.ValidationException;

import com.cg.employee.entity.Project;
import com.cg.employee.exception.ProjectNotFoundException;
import com.cg.employee.exception.ValidateException;

public interface IProjectService {
	public List<Project> getAllProject() throws ProjectNotFoundException;
	public Project addProject(Project project) throws ValidateException;
	public Project updateProject(Project project) throws ProjectNotFoundException, ValidateException ;
	public Project deleteProjectById(int id) throws ProjectNotFoundException;
	public List<Integer> getAllProjectCodes() throws ProjectNotFoundException;
	public Project findByCode(int projectCode) throws ProjectNotFoundException;
}