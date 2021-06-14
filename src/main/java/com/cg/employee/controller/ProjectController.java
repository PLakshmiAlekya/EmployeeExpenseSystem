package com.cg.employee.controller;

import java.util.List;
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
import com.cg.employee.entity.Project;
import com.cg.employee.exception.ProjectNotFoundException;
import com.cg.employee.exception.ValidateException;
import com.cg.employee.serviceImpl.ProjectService;

@RestController
public class ProjectController {
	@Autowired
	ProjectService proservice;

	//working
	@PostMapping("/addProject")
	public SuccessMessage addProject(@RequestBody Project project) throws ValidateException {
		proservice.addProject(project);
		return new SuccessMessage(Constants.PROJECT_ADDED);

	}
	//
	@PutMapping("/updateProject")
	public SuccessMessage updateProject(@RequestBody Project project) throws ProjectNotFoundException, ValidateException {
		proservice.updateProject(project);
		return new SuccessMessage(Constants.PROJECT_UPDATED);
	}

	@DeleteMapping("/deleteProject/{id}")
	public SuccessMessage deleteProjectById(@PathVariable ("id") int id) throws ProjectNotFoundException {
		proservice.deleteProjectById(id);
		return new SuccessMessage(Constants.PROJECT_DELETED);
	}

	@GetMapping("/getProject/{id}")
	public Project findByCode(@PathVariable("id") int projectCode) throws ProjectNotFoundException {
		return proservice.findByCode(projectCode);

	}

	@GetMapping("/viewAllProjects")
	public List<Project> getAllProject() throws ProjectNotFoundException {
		return proservice.getAllProject();
	}

	@GetMapping("/viewProjectCodes")
	public List<Integer> getAllProjectCodes() throws ProjectNotFoundException {
		return proservice.getAllProjectCodes();
	}

}