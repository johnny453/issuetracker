package com.johnmariyaselvam.issuetracker.Model;

import javax.persistence.*;

@Entity
@Table(name= "issue")
public class Issue {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="title")
    private String title;

    @Column(name="summary")
    private String summary;

    @Column(name="reporter")
    private String reporter;

    @Column(name="status")
    private String status;

    @Column(name="severity")
    private String severity;

    public Issue() {

    }

    public Issue(Integer id, String title, String summary, String reporter, String status, String severity) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.reporter = reporter;
        this.status = status;
        this.severity = severity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }
}
