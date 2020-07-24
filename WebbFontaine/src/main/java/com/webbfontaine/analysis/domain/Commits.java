package com.webbfontaine.analysis.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="commits")
public class Commits {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String userName;
	@Column(columnDefinition="TEXT")
	private String message;
	private String timeline;
//	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Projects.class)
//	@JoinColumn(name="productsId", insertable = false, updatable = false)
//	private Projects projects;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTimeline() {
		return timeline;
	}
	public void setTimeline(String string) {
		this.timeline = string;
	}
//	public Projects getProjects() {
//		return projects;
//	}
//	public void setProjects(Projects projects) {
//		this.projects = projects;
//	}

	
}
