/**
 * 
 */
package com.enndi.gitburn.model;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author gustavo
 *
 */
public class GBurndown {

	private Integer projectId;

	private String milestone;

	private Developers developers;

	private OffPlanning offPlanning;

	private OnPlanning onPlanning;

	public GBurndown() {
	}

	public GBurndown(Integer projectId, String milestone, List<GIssue> issues) {
		this.setMilestone(milestone);
		this.setProjectId(projectId);

		this.setOffPlanning(new OffPlanning());
		this.setOnPlanning(new OnPlanning());

		for (GIssue gIssue : issues) {
			boolean anyMatch = gIssue.getTags().stream().anyMatch(tag -> tag.equalsIgnoreCase("OffPlanning"));
			if (anyMatch) {
				this.getOffPlanning().addIssue(gIssue);
			} else {
				this.getOnPlanning().addIssue(gIssue);
			}
		}
	}

	public OffPlanning getOffPlanning() {
		return offPlanning;
	}

	@JsonSerialize
	public int quantity() {
		return this.getOffPlanning().size() + this.getOnPlanning().size();
	}

	@JsonSerialize
	public int points() {
		return this.getOffPlanning().points() + this.getOnPlanning().points();
	}

	public void setOffPlanning(OffPlanning offPlanning) {
		this.offPlanning = offPlanning;
	}

	public Planning getOnPlanning() {
		return onPlanning;
	}

	public void setOnPlanning(OnPlanning onPlanning) {
		this.onPlanning = onPlanning;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getMilestone() {
		return milestone;
	}

	public void setMilestone(String milestone) {
		this.milestone = milestone;
	}

	public Developers getDevelopers() {
		return developers;
	}

	public void setDevelopers(Developers developers) {
		this.developers = developers;
	}

}
