package com.enndi.git.statistics;

import java.util.List;

import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.Pager;
import org.gitlab4j.api.models.Board;
import org.gitlab4j.api.models.BoardList;
import org.gitlab4j.api.models.Issue;
import org.gitlab4j.api.models.IssueFilter;
import org.gitlab4j.api.models.Milestone;
import org.gitlab4j.api.models.Project;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StatisticsApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StatisticsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Create a GitLabApi instance to communicate with your GitLab server
		GitLabApi gitLabApi = new GitLabApi("http://gitlab.usto.re", "mxNwqAQW5KPBz7Ehy19M");
		IssueFilter issueFilter = new IssueFilter();
		issueFilter.withMilestone("Ouve Meu Disco");
		
		List<Issue> issues = gitLabApi.getIssuesApi().getIssues(47, issueFilter);
		for (Issue issue : issues) {
			Milestone milestone = issue.getMilestone();
			System.out.println(issue.getTitle());
		}
		System.out.println(issues.size());
		gitLabApi.close();
	}

}
