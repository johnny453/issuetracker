package com.johnmariyaselvam.issuetracker.AcceptanceTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.johnmariyaselvam.issuetracker.Model.Issue;
import com.johnmariyaselvam.issuetracker.Repository.IssueRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@ActiveProfiles("test")
public class IssueControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        Issue newIssue = new Issue();
        newIssue.setTitle("Blue line when navigating to Home screen");
        newIssue.setSummary("When I navigate to the home screen, I see a blue line.");
        newIssue.setReporter("Abigail");
        newIssue.setStatus("In Testing");
        newIssue.setSeverity("Critical");


        this.mockMvc.perform(post("/issue/add").contentType("application/json")
                .content(String.valueOf(newIssue)))
                .andDo(print())
                .andExpect(status().isOk());
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
                .andExpect(status().isOk());

    }

    @Test
    public void addOneIssue() throws Exception {

        Issue newIssue = new Issue();
        newIssue.setTitle("Blue line when navigating to Home screen");
        newIssue.setSummary("When I navigate to the home screen, I see a blue line.");
        newIssue.setReporter("Abigail");
        newIssue.setStatus("In Testing");
        newIssue.setSeverity("Critical");


        this.mockMvc.perform(post("/issue/add").contentType("application/json")
                    .content(String.valueOf(newIssue)))
                    .andDo(print())
                    .andExpect(status().isOk());
    }

    @Test
    public void deleteIssue() throws Exception {


        this.mockMvc.perform(delete("/issue/delete/1").contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    public void updateIssue() throws Exception {


        this.mockMvc.perform(put("/issue/update/1").contentType("application/json"))
                .andExpect(status().isOk());
    }

}
