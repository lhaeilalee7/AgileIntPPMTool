package com.webbfontaine.analysis.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.webbfontaine.analysis.domain.Commits;
import com.webbfontaine.analysis.domain.Projects;
import com.webbfontaine.analysis.helper.JsonFetcher;
import com.webbfontaine.analysis.repositories.CommitsRepository;
import com.webbfontaine.analysis.repositories.DatasRepository;


@Service
public class DataService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DataService.class);
	
	private Projects projects;
	private Commits commits;
	
	@Autowired
	private JsonFetcher jsonFetcher;
	
	@Autowired
	private DatasRepository datasRepository;
	
	@Autowired
	private CommitsRepository commitsRepository;
	
	public List<Projects> findAllProjects() {
		
		String urlString = "https://api.github.com/repositories";
		List<JSONObject> jsonObjectList = jsonFetcher.urlToJson(urlString);
		
		List<Projects> projectList = new ArrayList<>();
		if(jsonObjectList != null) {
			System.out.println("Count " + jsonObjectList.size());
			jsonObjectList.stream().forEach(jsonObject -> {
				
					projects = new Projects();
					projects.setName(jsonObject.getString("name"));
					projects.setCommitUrl((jsonObject.getString("commits_url")));
					projectList.add(projects);
				});
			}
		return projectList;
	}
	
	public List<Commits> findCommitters(String urlString, Long id) {
		
		List<JSONObject> jsonObjectList = jsonFetcher.urlToJson(urlString);
		
		List<Commits> commitList = new ArrayList<>();
		if(jsonObjectList != null) {
			System.out.println("Count " + jsonObjectList.size());
			jsonObjectList.stream().forEach(jsonObject -> {
				
					commits = new Commits();
					commits.setUserName(jsonObject.getJSONObject("commit").getJSONObject("committer").getString("name"));
					commits.setMessage(jsonObject.getJSONObject("commit").getString("message"));
					commits.setTimeline(jsonObject.getJSONObject("commit").getJSONObject("committer").getString("date"));
					
					commitList.add(commits);
			});
		}
		return commitList;
	}

	public List<Projects> setCommitters(List<Projects> projectList) {
		projectList.stream().forEach(project -> {
			String strUrl = project.getCommitUrl();
			String tempUrl = strUrl.substring(0, strUrl.indexOf("{"));
			project.setCommitList(findCommitters(tempUrl, project.getProductsId()));
		});
		return projectList;
	}
	
	public void saveProjects(List<Projects> projectList) {
		projectList.stream().forEach(project -> {
			datasRepository.save(project);
		});
	}

	public Projects saveProjects(Projects project) {
			project.getCommitList().stream().forEach( 
					commit -> {
						commitsRepository.save(commit);
					});
			return datasRepository.save(project);
	}

}
