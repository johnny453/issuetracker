package com.johnmariyaselvam.issuetracker.Repository;

import com.johnmariyaselvam.issuetracker.Model.Issue;
import org.springframework.data.repository.CrudRepository;

public interface IssueRepository extends CrudRepository<Issue, Integer> {

    Issue findByTitle(String title);

}
