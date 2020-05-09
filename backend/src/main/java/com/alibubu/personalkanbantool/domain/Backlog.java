package com.alibubu.personalkanbantool.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Backlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Backlog() {
    }

    private Integer ptSequence = 0;
    private String projectIdentifier;

    //OneToOne association with project
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="project_id", nullable = false)   //link with the project by this attribute project_Id
    @JsonIgnore       //ignore this attribute in the JSON response - and avoid infinite reply loop in JSON response!
    private Project project;

    public List<ProjectTask> getProjectTaskList() {
        return projectTaskList;
    }

    public void setProjectTaskList(List<ProjectTask> projectTaskList) {
        this.projectTaskList = projectTaskList;
    }

    //OneToMany association with project task
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "backlog", orphanRemoval = true) //orphanRemoval so that when this is removed, all "many" side linked to it will be deleted as well
    private List<ProjectTask> projectTaskList = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPtSequence() {
        return ptSequence;
    }

    public void setPtSequence(Integer ptSequence) {
        this.ptSequence = ptSequence;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
