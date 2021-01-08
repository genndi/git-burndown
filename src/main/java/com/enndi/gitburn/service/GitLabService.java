package com.enndi.gitburn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.models.Issue;
import org.gitlab4j.api.models.IssueFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.enndi.gitburn.model.GBurndown;
import com.enndi.gitburn.model.GIssue;

@Service
public class GitLabService {

	private Logger logger = LoggerFactory.getLogger(GitLabService.class);
	
	@Value("${gitburn.gitlab.hostUrl}")
	private String hostUrl;
	
	@Value("${gitburn.gitlab.personalAccessToken}")
	private String personalAccessToken;
	
	public List<GIssue> getIssues(Integer projectId, String milestone) {
		List<GIssue> gIssues = null;
		try {
			GitLabApi gitLabApi = new GitLabApi(hostUrl, personalAccessToken);
			IssueFilter issueFilter = new IssueFilter();
			issueFilter.withMilestone(milestone);

			List<Issue> issues = gitLabApi.getIssuesApi().getIssues(projectId, issueFilter);
			gIssues = issues.stream().map(issue -> new GIssue(issue, issue.getMilestone())).collect(Collectors.toList());
			gitLabApi.close();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			gIssues = new ArrayList<>();
		}
		return gIssues;
	}

	public GBurndown generateBurndown(Integer projectId, String milestone) {
		List<GIssue> issues = getIssues(projectId, milestone);
		GBurndown gBurndown = new GBurndown(projectId, milestone, issues);
		return gBurndown;
	}

}
