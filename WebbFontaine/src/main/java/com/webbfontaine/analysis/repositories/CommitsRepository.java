package com.webbfontaine.analysis.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.webbfontaine.analysis.domain.Commits;

@Repository
public interface CommitsRepository extends CrudRepository<Commits, Long> {

}
