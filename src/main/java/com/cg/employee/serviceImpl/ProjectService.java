package com.cg.employee.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.employee.constants.Constants;
import com.cg.employee.entity.Project;
import com.cg.employee.exception.ProjectNotFoundException;
import com.cg.employee.exception.ValidateException;
import com.cg.employee.repository.IProjectRepository;
import com.cg.employee.service.IProjectService;

@Service
public class ProjectService implements IProjectService {
	@Autowired
	IProjectRepository projRepository;

	@Override
	public Project addProject(Project project) throws ValidateException {
		validateProject(project);
		return projRepository.save(project);

	}

	@Override
	public Project updateProject(Project project) throws ProjectNotFoundException, ValidateException {
		Optional<Project> pro = projRepository.findById(project.getProjectCode());
		if (pro.isPresent()) {
			// Project p = pro.get();
			project.setProjectDescription(project.getProjectDescription());
			project.setStartDate(project.getStartDate());
			project.setEndDate(project.getEndDate());
			validateProject(project);
			Project newProject = projRepository.save(project);
		} else {
			throw new ProjectNotFoundException(Constants.PROJECT_NOT_FOUND);
		}
		return null;
	}

	@Override
	public Project deleteProjectById(int projectCode) throws ProjectNotFoundException {
		Optional<Project> pro = projRepository.findById(projectCode);
		if (!pro.isPresent()) {
			throw new ProjectNotFoundException(Constants.PROJECT_NOT_FOUND);
		} else {
			projRepository.deleteById(projectCode);
		}
		return null;
	}

	@Override
	public Project findByCode(int projectCode) throws ProjectNotFoundException {
		Optional<Project> pro = projRepository.findById(projectCode);
		if (pro.isPresent()) {
			return projRepository.findById(projectCode).get();
		} else {
			throw new ProjectNotFoundException(Constants.PROJECT_NOT_FOUND);
		}
	}

	@Override
	public List<Project> getAllProject() throws ProjectNotFoundException {
		List<Project> prolist = projRepository.findAll();
		if (prolist.isEmpty())
			throw new ProjectNotFoundException(Constants.NO_PROJECTS);
		prolist.sort((p1, p2) -> p1.getProjectDescription().compareTo(p2.getProjectDescription()));
		return prolist;
	}

	@Override
	public List<Integer> getAllProjectCodes() throws ProjectNotFoundException {
		List<Project> projlist = new ArrayList<Project>();
		projlist = projRepository.findAll();
		if (projlist.isEmpty())
			throw new ProjectNotFoundException(Constants.NO_PROJECTS_IDS);
		List<Integer> projCodes = new ArrayList<Integer>();
		Iterator itr = projlist.iterator();
		while (itr.hasNext()) {
			Project p = (Project) itr.next();
			projCodes.add(p.getProjectCode());
		}
		return projCodes;
	}

	public boolean validateProject(Project project) throws ValidateException {
		if (!project.getProjectDescription().matches(Constants.DESCRIPTION_PATTERN)) {
			throw new ValidateException(Constants.PROJECT_DESCRIPTION_CANNOT_BE_EMPTY);
		}
		if(!(project.getStartDate().isBefore(project.getEndDate()))) {
				throw new ValidateException(Constants.WRONG_DATE_INPUT);
			}
			else {
				return false;
			}
}

}
