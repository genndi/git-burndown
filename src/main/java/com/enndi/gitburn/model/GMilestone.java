/**
 * 
 */
package com.enndi.git.statistics.git.model;

import java.util.Date;

/**
 * @author gustavo
 *
 */
public class Milestone {
	private Date createdAt;
	private String description;
	private Date startDate;
	private Date dueDate;
	private String state;
	private String title;

	public Milestone() {
	}
	public Milestone(org.gitlab4j.api.models.Milestone milestone) {
		this.setCreatedAt(milestone.getCreatedAt());
		this.setDescription(milestone.getDescription());
		this.setStartDate(milestone.getStartDate());
		this.setDueDate(milestone.getDueDate());
		this.setState(milestone.getState());
		this.setTitle(milestone.getTitle());
	}

	public String getDescription() {
		return description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
