package com.johnmariyaselvam.issuetracker.UnitTests;

import com.johnmariyaselvam.issuetracker.Model.Issue;
import com.johnmariyaselvam.issuetracker.Repository.IssueRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class IssueRepositoryTest {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    public IssueRepository issueRepository;

    Issue issue1 = new Issue(1, "Settings is spelled incorrectly",
            "In the settings page, the settings header is spelled as 'Setinngs'", "Phil", "Backlog", "High");
    Issue issue2 = new Issue(2, "Audio starts recording when microphone permission is denied",
            "When I click on 'Record' and deny the microphone permission, audio starts recording", "Amy", "In Testing", "Low");
    Issue issue3 = new Issue(3, "Scroller does not scroll down",
            "I am not able to scroll down the webpage", "Claire", "In Development", "High");

    @Test
    public void addIssue() {

        issueRepository.save(issue1);
        assertThat(issueRepository.count()).isEqualTo(1);

    }

    @Test
    public void getOneIssue() {

        issueRepository.save(issue1);
        assertThat(issueRepository.findByTitle("Settings is spelled incorrectly"));
    }

    @Test
    public void deleteIssue() {

        issueRepository.save(issue1);
        issueRepository.deleteById(issue1.getId());
        assertThat(issueRepository.count()).isEqualTo(0);
    }


    @Test
    public void deleteAllIssues() {

        issueRepository.save(issue1);
        issueRepository.save(issue2);
        issueRepository.save(issue3);
        issueRepository.deleteAll();
        assertThat(issueRepository.count()).isEqualTo(0);


        }

    @Test
    public void getAllIssues() {

        issueRepository.save(issue1);
        issueRepository.save(issue2);
        issueRepository.save(issue3);
        assertThat(issueRepository.count()).isEqualTo(3);
    }

    @Test
    public void updateIssue() {

        issueRepository.save(issue1);

        issue1.setTitle("Charts is spelled incorrectly");
        issue1.setSummary("In the charts page, the charts header is spelled as 'Chrts'");
        issue1.setReporter("Jamie");
        issue1.setStatus("In Development");
        issue1.setSeverity("Low");

        issueRepository.save(issue1);
        assertThat(issue1.getTitle()).isEqualTo("Charts is spelled incorrectly");

    }

}

