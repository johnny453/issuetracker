package com.johnmariyaselvam.issuetracker.Controller;
import com.johnmariyaselvam.issuetracker.Model.Issue;
import com.johnmariyaselvam.issuetracker.Repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class IssueController {

    @Autowired
    IssueRepository issueRepository;

    @GetMapping(value = "/issue/{id}", produces = {"application/json"})
    public Optional<Issue> getOneIssue(@PathVariable Integer id) {
        return issueRepository.findById(id);
    }

    @PostMapping(value = "/issue/add", produces = {"application/json"})
    public @ResponseBody void addIssue(@RequestBody Issue issue) {
        issueRepository.save(issue);
    }

    @DeleteMapping(value = "/issue/delete/{id}")
    public @ResponseBody void deleteIssue(@PathVariable Integer id) {
        issueRepository.deleteById(id);
    }

    @PutMapping(value = "/issue/update/{id}", produces = {"application/json"})
    public Issue updateIssue(@RequestBody Issue issue, @PathVariable Integer id) {

        Issue newIssue = issueRepository.findById(id).orElse(new Issue());
        newIssue.setTitle(issue.getTitle());
        newIssue.setSummary(issue.getSummary());
        newIssue.setReporter(issue.getReporter());
        newIssue.setStatus(issue.getStatus());
        newIssue.setSeverity(issue.getSeverity());

        return issueRepository.save(newIssue);

    }

    @GetMapping(value = "/issue/all", produces = {"application/json"})
    public @ResponseBody Iterable<Issue> getAllSongs() {
        return issueRepository.findAll();
    }

    @DeleteMapping(value = "/issue/delete/all")
    public void deleteAllIssues() {
        issueRepository.deleteAll();
    }
}
