package com.alibubu.personalkanbantool.domain;

import javax.persistence.*;

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
    @JoinColumn(name="project_id", nullable = false)
    private Project project;

    //OneToMany association with project task


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
