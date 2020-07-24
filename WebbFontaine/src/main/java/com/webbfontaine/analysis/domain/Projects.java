package com.webbfontaine.analysis.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "projects")
public class Projects {
	
	//private List<Commits> projectList;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productsId", unique = true, nullable = false)
    private Long productsId;
	private String name;
	private String commitUrl;
	
//	@ElementCollection
//    @CollectionTable(name="commits")
//	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinColumn(name="COMMIT_LIST_ID")
	// @OneToMany(orphanRemoval = true, mappedBy = "projects")
	//@OneToMany(fetch = FetchType.LAZY,mappedBy = "projects")
	//private Commits commits;
	@OneToMany
	@JoinColumn(name = "productsId", referencedColumnName = "productsId")
	private List<Commits> commitList;
	

//    @OneToMany(orphanRemoval = true, mappedBy = "projects")
//    private Commits commits;
	
	public Long getProductsId() {
		return productsId;
	}
	public void setProductsId(Long productsId) {
		this.productsId = productsId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCommitUrl() {
		return commitUrl;
	}
	public void setCommitUrl(String commitUrl) {
		this.commitUrl = commitUrl;
	}
	public List<Commits> getCommitList() {
		return commitList;
	}
	public void setCommitList(List<Commits> commitList) {
		this.commitList = commitList;
	}
	
	
//	public List<Commits> getProjectList() {
//		return projectList;
//	}
//	public void setProjectList(List<Commits> projectList) {
//		this.projectList = projectList;
//	}
	
	
	
}
