package io.agileintelligence.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.agileintelligence.ppmtool.domain.Backlog;
import io.agileintelligence.ppmtool.domain.ProjectTask;
import io.agileintelligence.ppmtool.repositories.BacklogRepository;
import io.agileintelligence.ppmtool.repositories.ProjectTaskRepository;

@Service
public class ProjectTaskService {
	
	@Autowired
	private BacklogRepository backlogRepository;
	
	@Autowired
	private ProjectTaskRepository projectTaskRepository;
	
	public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask) {
		//PTs to be added to a specific project, project != null, BL exists
		Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);
		//set the backlog to pt
		projectTask.setBacklog(backlog);
		//we want our project sequence to be like this: IDPRO-1 IDPRO-2 ...100 101
		Integer backlogSequence = backlog.getPTSequence();
		
		//Update the BL SEQUENCE
		backlogSequence++;
		
		backlog.setPTSequence(backlogSequence);
		
		//Add Sequence to Project Task
		projectTask.setProjectSequence(projectIdentifier + "-" + backlogSequence);
		projectTask.setProjectIdentifier(projectIdentifier);
		
		
		//INITIAL status when status is null
		if(projectTask.getStatus()=="" || projectTask.getStatus() == null) {
			projectTask.setStatus("TO_DO");
		}
		
		//INITIAL priority when priority  null
		if(projectTask.getPriority() == null) { // In the future we need projectTask.getPriority()=0 to handle the form
			projectTask.setPriority(3);
		}
		
		return projectTaskRepository.save(projectTask);
	}
	
}
