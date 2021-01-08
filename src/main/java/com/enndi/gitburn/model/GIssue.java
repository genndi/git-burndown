/**
 * 
 */
package com.enndi.gitburn.model;

import java.util.ArrayList;
import java.util.List;

import org.gitlab4j.api.models.Issue;
import org.gitlab4j.api.models.Milestone;

/**
 * @author gustavo
 *
 */
public class GIssue {

	private String title;
	private String description;
	private String webUrl;
	private String state;
	private GMilestone milestone;
	private List<String> tags = new ArrayList<>();
	
	public GIssue() {
	}
	
	public GIssue(Issue issue, Milestone milestone) {
		this.setTitle(issue.getTitle());
		this.setDescription(issue.getDescription());
		this.setWebUrl(issue.getWebUrl());
		this.setState(issue.getState().name());
		this.setTags(issue.getLabels());
		if(milestone != null) {
			this.setMilestone(new GMilestone(milestone));			
		}
	}
	public boolean hasVoting() {
		boolean hasVoting = false;
		for (String tag : this.getTags()) {
			if(tag.matches("-?\\d+(\\.\\d+)?")) {
				hasVoting = true;
				break;
			}
		}
		return hasVoting;
	}
	
	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public GMilestone getMilestone() {
		return milestone;
	}

	public void setMilestone(GMilestone milestone) {
		this.milestone = milestone;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
