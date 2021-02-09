//package com.johnmariyaselvam.issuetracker.AcceptanceTests;
//
//import com.johnmariyaselvam.issuetracker.Controller.IssueController;
//import com.johnmariyaselvam.issuetracker.Model.Issue;
//import com.johnmariyaselvam.issuetracker.Service.IssueService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultMatcher;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
//import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.BDDMockito.willReturn;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(IssueController.class)
//public class IssueControllerTest {
//
//    public IssueControllerTest() {
//
//    }
//
//    @Autowired
//    private MockMvc mvc;
////
////    @MockBean
////    private IssueService issueService;
////
//
////        String firstIssue = ("{\"id\":\"1\",\"title\":\"Settings is spelled incorrectly\",\"summary\":\"In the settings page, the settings header is spelled as 'Setinngs'\"," +
////         "\"reporter\":\"Phil\",\"status\":\"In Development\",\"severity\":\"Low\"}");
////        String secondIssue = ("{\"id\":\"2\",\"title\":\"Crash when opening app\",\"summary\":\"When I open the app, it crashes\"," +
////            "\"reporter\":\"Jimmy\",\"status\":\"In Testing\",\"severity\":\"Critical\"}");
////        String thirdIssue = ("{\"id\":\"3\",\"title\":\"Twitter does not open when I tap on 'Open in Twitter'\",\"summary\":\"When I tap open in Twitter button, it does not open Twitter\"," +
////            "\"reporter\":\"John\",\"status\":\"Done\",\"severity\":\"Low\"}");
//
////    public void setUpAddIssues(String addedIssue) throws  Exception {
////
////        String uri = "/issue";
////        mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(addedIssue)).andReturn();
////    }
//
////    @Before
////    public void setUp() throws Exception {
////
////        System.out.println("setting up");
////        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
////
////        setUpAddIssues(firstIssue);
////        setUpAddIssues(secondIssue);
////        setUpAddIssues(thirdIssue);
////    }
//
//
//
//    @Test
//    public void getAllIssues() throws Exception {
//
////        Issue issue1 = new Issue(1, "Settings is spelled incorrectly",
////                "In the settings page, the settings header is spelled as 'Setinngs'", "Phil", "Backlog", "High");
////        Issue issue2 = new Issue(2, "Audio starts recording when microphone permission is denied",
////                "When I click on 'Record' and deny the microphone permission, audio starts recording", "Amy", "In Testing", "Low");
////        Issue issue3 = new Issue(3, "Scroller does not scroll down",
////                "I am not able to scroll down the webpage", "Claire", "In Development", "High");
////
////        List<Issue> allIssues = Arrays.asList(issue1);
////
////        given(issueService.getAllIssues()).willReturn(allIssues);
////
////        mvc.perform(get("/issue")
////                .contentType(MediaType.APPLICATION_JSON))
////                .andExpect(status().isOk())
////                .andExpect(jsonPath("$", hasSize(1)))
////                .andExpect((ResultMatcher) MockMvcResultMatchers.jsonPath("$[0].title", is("'Settings is spelled incorrectly'")));
////
//
//        List<Long> list = new ArrayList<>();
//        list.add(1L);
//
//        Issue issue = new Issue();
//        List<Issue> issues = new ArrayList<>();
//
//        issue.setId(1);
//        issue.setTitle("Settings is spelled incorrectly");
//        issue.setSummary("In the settings page, the settings header is spelled as 'Setinngs'");
//        issue.setReporter("Phil");
//        issue.setStatus("Backlog");
//        issue.setSeverity("High");
//
//        issues.add(issue);
//
//        given(this.issueService.getAllIssues()).willReturn(issues);
//
//        this.mvc.perform(get("/issue")
//                .header("Accept-Language", "en-US,en;q=0.8,zh-CN;q=0.6,zh;q=0.4")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//
//                //check is json node exists
//
//                .andExpect(jsonPath("[0].title").value("Settings is spelled incorrectly"))
//                .andExpect(jsonPath("[0].summary").value("In the settings page, the settings header is spelled as 'Setinngs'"))
//                .andExpect(jsonPath("[0].reporter").value("Phil"))
//                .andExpect(jsonPath("[0].status").value("Backlog"))
//                .andExpect(jsonPath("[0].severity").value("High"))
//                .andExpect(jsonPath("[0].id").value(1));
//
//    }
//
//    @Test
//    public void deleteIssue() throws Exception {
//
//        List<Long> list = new ArrayList<>();
//        list.add(1L);
//
//        Issue issue = new Issue();
//        List<Issue> issues = new ArrayList<>();
//
//        issue.setId(1);
//        issue.setTitle("Settings is spelled incorrectly");
//        issue.setSummary("In the settings page, the settings header is spelled as 'Setinngs'");
//        issue.setReporter("Phil");
//        issue.setStatus("Backlog");
//        issue.setSeverity("High");
//
//        issues.add(issue);
//
//        given(this.issueService.getAllIssues()).willReturn(issues);
//
//        this.mvc.perform(delete("/issue")
//                .header("Accept-Language" , "en-US,en;q=0.8,zh-CN;q=0.6,zh;q=0.4")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//
//                //check is json node exists
//
//                .andExpect(jsonPath("[0].title").value(null))
//                .andExpect(jsonPath("[0].summary").value(null))
//                .andExpect(jsonPath("[0].reporter").value(null))
//                .andExpect(jsonPath("[0].status").value(null))
//                .andExpect(jsonPath("[0].severity").value(null))
//                .andExpect(jsonPath("[0].id").value(null));
//
//
//    }
//
//
//}
