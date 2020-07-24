package com.webbfontaine.analysis.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webbfontaine.analysis.domain.Projects;
import com.webbfontaine.analysis.service.DataService;

@RestController
@RequestMapping("/api/project")
public class DatasController {
	
	@Autowired
	private DataService dataService;

	@PostMapping("")
	public ResponseEntity<?> getProjectsAndSave(@RequestBody List<Projects> projectList, BindingResult result){
		
//		List<Projects> projectList = dataService.findAllProjects();
//		dataService.setCommitters(projectList);
//		dataService.saveProjects(projectList);
//		return new ResponseEntity<List<Projects>>(projectList, HttpStatus.OK);
		
		projectList.stream().forEach(project -> {dataService.saveProjects(project);});
		
		return new ResponseEntity<List<Projects>>(projectList, HttpStatus.OK);
	}
}
