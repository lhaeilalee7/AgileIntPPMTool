package com.webbfontaine.analysis.repositories;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.webbfontaine.analysis.domain.*;
import com.webbfontaine.analysis.helper.JsonFetcher;

@Repository
public interface DatasRepository extends CrudRepository<Projects, Long> {
//	List<Commits> findAllProjects();
	Iterable<Projects> findAll();
//	Projects findAllProjectsByName(Iterable<String> projectName);
}
