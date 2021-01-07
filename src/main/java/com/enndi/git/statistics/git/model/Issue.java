/**
 * 
 */
package com.enndi.git.statistics.git.model;

/**
 * @author gustavo
 *
 */
public class Issue {

	private String title;
	private String description;
	private String webUrl;
	private String state;
	private Milestone milestone;
	
	public Issue() {
	}
	
	public Issue(org.gitlab4j.api.models.Issue issue, org.gitlab4j.api.models.Milestone milestone) {
		this.setTitle(issue.getTitle());
		this.setDescription(issue.getDescription());
		this.setWebUrl(issue.getWebUrl());
		this.setState(issue.getState().name());
		this.setMilestone(new Milestone(milestone));
	}
	
	
	public Milestone getMilestone() {
		return milestone;
	}

	public void setMilestone(Milestone milestone) {
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
