package com.alibubu.personalkanbantool.services;

import com.alibubu.personalkanbantool.domain.ProjectTask;
import com.alibubu.personalkanbantool.repositories.BacklogRepository;
import com.alibubu.personalkanbantool.repositories.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskService {
    @Autowired
    private BacklogRepository backlogRepository;

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    public ProjectTask addProjectTask(String projectIdentifier){
        //PTs to be added to a specific non-null project, Backlog exists
        //set backlog to the project task



        //IDPROJECT-1 (ID within the project only). We want our project sequence to be like this
        //update the backlog sequence

        //initial priority when priority is NULL
        //initial status when status is NULL

    }
}
