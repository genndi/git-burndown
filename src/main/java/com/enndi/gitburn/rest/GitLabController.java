/**
 * 
 */
package com.enndi.gitburn.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enndi.gitburn.model.GBurndown;
import com.enndi.gitburn.model.GIssue;
import com.enndi.gitburn.service.GitLabService;

/**
 * @author gustavo
 *
 */
@RestController
@RequestMapping("/gitlab")
public class GitLabController {

	@Autowired
	private GitLabService gitLabService;

	@GetMapping("/project/{id}/burndown")
	public GBurndown generateBurndown(@PathVariable("id") Integer id,
			@RequestParam(name = "milestone", defaultValue = "all") String milestone) {
		GBurndown burn = gitLabService.generateBurndown(id, milestone);
		return burn;
	}

	@GetMapping("/project/{id}/issue")
	public List<GIssue> getIssues(@PathVariable("id") Integer id,
			@RequestParam(name = "milestone", defaultValue = "all") String milestone) {
		List<GIssue> issues = gitLabService.getIssues(id, milestone);
		return issues;
	}

}
