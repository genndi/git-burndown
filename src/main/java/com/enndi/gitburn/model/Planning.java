package com.enndi.gitburn.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Planning {

	private List<GIssue> issues = new ArrayList<>();

	public Planning() {
	}

	public List<GIssue> getIssues() {
		return issues;
	}

	public void setIssues(List<GIssue> issues) {
		this.issues = issues;
	}

	@JsonSerialize
	public int size() {
		return this.getIssues().size();
	}

	@JsonSerialize
	public int quantityWithoutVoting() {
		int quantityWithoutVoting = 0;
		List<GIssue> issues = this.getIssues();
		for (GIssue gIssue : issues) {
			if (!gIssue.hasVoting()) {
				quantityWithoutVoting += 1;
			}
		}
		return quantityWithoutVoting;
	}

	@JsonSerialize
	public int points() {
		List<GIssue> issues = this.getIssues();
		BigDecimal sum = issues.stream().map(issue -> {
			Optional<String> optional = issue.getTags().stream().filter(tag -> tag.matches("-?\\d+(\\.\\d+)?"))
					.findFirst();
			if (optional.isPresent()) {
				return new BigDecimal(optional.get());
			} else {
				return BigDecimal.ZERO;
			}
		}).reduce(BigDecimal.ZERO, BigDecimal::add);
		return sum.intValue();
	}

	public void addIssue(GIssue gIssue) {
		this.getIssues().add(gIssue);
	}

}