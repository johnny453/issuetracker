package com.johnmariyaselvam.issuetracker.AcceptanceTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.johnmariyaselvam.issuetracker.Model.Issue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class IssueControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    ObjectMapper objectMapper = new ObjectMapper();
    Issue issueOne = new Issue();
    Issue issueTwo = new Issue();
    Issue issueThree = new Issue();


    public void setUpAddIssues() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        ArrayList<Issue> issues = new ArrayList<>();

        issueOne.setTitle("Blue line when navigating to Home screen");
        issueOne.setSummary("When I navigate to the home screen, I see a blue line.");
        issueOne.setReporter("Abigail");
        issueOne.setStatus("In Testing");
        issueOne.setSeverity("Critical");
        issues.add(issueOne);


        issueTwo.setTitle("Red line when navigating to Home screen");
        issueTwo.setSummary("When I navigate to the home screen, I see a blue line.");
        issueTwo.setReporter("Abigail");
        issueTwo.setStatus("In Testing");
        issueTwo.setSeverity("Critical");
        issues.add(issueTwo);


        issueThree.setTitle("Blue line when navigating to Home screen");
        issueThree.setSummary("When I navigate to the home screen, I see a blue line.");
        issueThree.setReporter("Abigail");
        issueThree.setStatus("In Testing");
        issueThree.setSeverity("Critical");
        issues.add(issueThree);

        for (Issue issue : issues) {
            this.mockMvc.perform(post("/issue/add").contentType("application/json")
                    .content(objectMapper.writeValueAsString(issue)));
        }
    }

    @Test
    public void getAllIssues() throws Exception {

        setUpAddIssues();

        this.mockMvc.perform(get("/issue/all").contentType("application/json"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$[0].title", is(issueOne.getTitle())))
                .andExpect(jsonPath("$[0].summary", is(issueOne.getSummary())))
                .andExpect(jsonPath("$[0].reporter", is(issueOne.getReporter())))
                .andExpect(jsonPath("$[0].status", is(issueOne.getStatus())))
                .andExpect(jsonPath("$[0].severity", is(issueOne.getSeverity())))

                .andExpect(jsonPath("$[1].title", is(issueTwo.getTitle())))
                .andExpect(jsonPath("$[1].summary", is(issueTwo.getSummary())))
                .andExpect(jsonPath("$[1].reporter", is(issueTwo.getReporter())))
                .andExpect(jsonPath("$[1].status", is(issueTwo.getStatus())))
                .andExpect(jsonPath("$[1].severity", is(issueTwo.getSeverity())))

                .andExpect(jsonPath("$[2].title", is(issueThree.getTitle())))
                .andExpect(jsonPath("$[2].summary", is(issueThree.getSummary())))
                .andExpect(jsonPath("$[2].reporter", is(issueThree.getReporter())))
                .andExpect(jsonPath("$[2].status", is(issueThree.getStatus())))
                .andExpect(jsonPath("$[2].severity", is(issueThree.getSeverity())));
    }

    @Test
    public void getOneIssue() throws Exception {

        setUpAddIssues();

        this.mockMvc.perform(get("/issue/1").contentType("application/json"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.title", is(issueOne.getTitle())))
                .andExpect(jsonPath("$.summary", is(issueOne.getSummary())))
                .andExpect(jsonPath("$.reporter", is(issueOne.getReporter())))
                .andExpect(jsonPath("$.status", is(issueOne.getStatus())))
                .andExpect(jsonPath("$.severity", is(issueOne.getSeverity())));
    }

    @Test
    public void addOneIssue() throws Exception {

        issueOne.setId(1);
        issueOne.setTitle("Blue line when navigating to Home screen");
        issueOne.setSummary("When I navigate to the home screen, I see a blue line.");
        issueOne.setReporter("Abigail");
        issueOne.setStatus("In Testing");
        issueOne.setSeverity("Critical");

        this.mockMvc.perform(post("/issue/add").contentType("application/json")
                .content(objectMapper.writeValueAsString(issueOne)));

        this.mockMvc.perform(get("/issue/1").contentType("application/json"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.id", is(issueOne.getId())))
                .andExpect(jsonPath("$.title", is(issueOne.getTitle())))
                .andExpect(jsonPath("$.summary", is(issueOne.getSummary())))
                .andExpect(jsonPath("$.reporter", is(issueOne.getReporter())))
                .andExpect(jsonPath("$.status", is(issueOne.getStatus())))
                .andExpect(jsonPath("$.severity", is(issueOne.getSeverity())));
    }

    @Test
    public void deleteIssue() throws Exception {

        issueOne.setId(1);
        issueOne.setTitle("Blue line when navigating to Home screen");
        issueOne.setSummary("When I navigate to the home screen, I see a blue line.");
        issueOne.setReporter("Abigail");
        issueOne.setStatus("In Testing");
        issueOne.setSeverity("Critical");

        this.mockMvc.perform(post("/issue/add").contentType("application/json")
                .content(objectMapper.writeValueAsString(issueOne)));

        this.mockMvc.perform(delete("/issue/delete/1").contentType("application/json"))
                .andExpect(status().isOk());

        this.mockMvc.perform(get("/issue/1").contentType("application/json"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    public void deleteAllIssuesWillResultInEmptyArray() throws Exception {

        setUpAddIssues();
        this.mockMvc.perform(delete("/issue/delete/all").contentType("application/json"))
                .andExpect(status().isOk());

        this.mockMvc.perform(get("/issue/all").contentType("application/json"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", is(empty())));
    }

    @Test
    public void updateIssueIfItExists() throws Exception {

        setUpAddIssues();

        this.mockMvc.perform(get("/issue/1").contentType("application/json"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        issueOne.setId(1);
        issueOne.setTitle("Red line when navigating to Home screen");
        issueOne.setSummary("When I navigate to the home screen, I see a red line.");
        issueOne.setReporter("Jimmy");
        issueOne.setStatus("In Development");
        issueOne.setSeverity("Low");

        this.mockMvc.perform(put("/issue/update/1").contentType("application/json")
                .content(objectMapper.writeValueAsString(issueOne)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.id", is(issueOne.getId())))
                .andExpect(jsonPath("$.title", is(issueOne.getTitle())))
                .andExpect(jsonPath("$.summary", is(issueOne.getSummary())))
                .andExpect(jsonPath("$.reporter", is(issueOne.getReporter())))
                .andExpect(jsonPath("$.status", is(issueOne.getStatus())))
                .andExpect(jsonPath("$.severity", is(issueOne.getSeverity())));
    }

    @Test
    public void requestingUpdateWillCreateIssueIfItDoesNotExist() throws Exception {
        setUpAddIssues();

        Issue issueFour = new Issue();
        issueFour.setId(4);
        issueFour.setTitle("App crashes when opening");
        issueFour.setSummary("When I open the app, it crashes");
        issueFour.setReporter("Fred");
        issueFour.setStatus("In Testing");
        issueFour.setSeverity("High");

        this.mockMvc.perform(put("/issue/update/4").contentType("application/json")
                .content(objectMapper.writeValueAsString(issueFour)))
                .andDo(print())
                .andExpect(jsonPath("$.id", is(issueFour.getId())))
                .andExpect(jsonPath("$.title", is(issueFour.getTitle())))
                .andExpect(jsonPath("$.summary", is(issueFour.getSummary())))
                .andExpect(jsonPath("$.reporter", is(issueFour.getReporter())))
                .andExpect(jsonPath("$.status", is(issueFour.getStatus())))
                .andExpect(jsonPath("$.severity", is(issueFour.getSeverity())));
    }

}
