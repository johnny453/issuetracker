package com.johnmariyaselvam.issuetracker.AcceptanceTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.johnmariyaselvam.issuetracker.Model.Issue;
import com.johnmariyaselvam.issuetracker.Repository.IssueRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
public class IssueControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setUp() {

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }

    @Test
    public void getAllIssues() throws Exception {

        this.mockMvc.perform(get("/issue/all").contentType("application/json"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void getOneIssue() throws Exception {

        this.mockMvc.perform(get("/issue/25").contentType("application/json"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Settings is spelled incorrectly"));

    }

    @Test
    public void addOneIssue() throws Exception {

        Issue newIssue = new Issue();
        newIssue.setTitle("Blue line when navigating to Home screen");
        newIssue.setSummary("When I navigate to the home screen, I see a blue line.");
        newIssue.setReporter("Abigail");
        newIssue.setStatus("In Testing");
        newIssue.setSeverity("Critical");


//        String addedIssue = "{\"id\":\"1\",\"title\":\"Blue line when navigating to Home screen\",\"summary\":\"When I navigate to the home screen, I see a blue line.\"," +
//         "\"reporter\":\"Abigail\",\"status\":\"In Testing\",\"severity\":\"Critical\"}";

        this.mockMvc.perform(post("/issue/add").contentType("application/json")
                    .content(objectMapper.writeValueAsString(newIssue)))
                    .andDo(print())
                    .andExpect(status().isOk());
//                    .andExpect(jsonPath("$[55].title").value("Blue line when navigating to Home screen"));


    }

}
