package com.alibubu.personalkanbantool.services;

import com.alibubu.personalkanbantool.domain.Backlog;
import com.alibubu.personalkanbantool.domain.ProjectTask;
import com.alibubu.personalkanbantool.exceptions.BacklogNotFoundException;
import com.alibubu.personalkanbantool.exceptions.ProjectTaskNotFoundException;
import com.alibubu.personalkanbantool.repositories.BacklogRepository;
import com.alibubu.personalkanbantool.repositories.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectTaskService {
    @Autowired
    private BacklogRepository backlogRepository;

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask){
        //PTs to be added to a specific non-null project, Backlog exists
        Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier.toUpperCase());

        if (backlog == null)
            throw new BacklogNotFoundException("Backlog Not Found!");
        //set backlog to the project task
        projectTask.setBacklog(backlog);

        //IDPROJECT-1 (ID within the project only). We want our project sequence to be like this
        Integer backlogSeq = backlog.getPtSequence();

        //update the backlog sequence
        backlogSeq++;
        backlog.setPtSequence(backlogSeq);

        //add PtSeq to the task
        projectTask.setProjectSequence(projectIdentifier.toUpperCase() + "-" + backlogSeq);
        projectTask.setProjectIdentifier(projectIdentifier.toUpperCase());

        //initial priority when priority is NULL
        if (projectTask.getPriority() == null || projectTask.getPriority() == 0)
            projectTask.setPriority(3);

        //initial status when status is NULL
        if (projectTask.getStatus() == null || projectTask.getStatus().equals(""))
            projectTask.setStatus("TO_DO");

        return projectTaskRepository.save(projectTask);
    }

    public Iterable<ProjectTask> findBacklogById(String backlog_id) {

        Backlog backlog = backlogRepository.findByProjectIdentifier(backlog_id.toUpperCase());

        if (backlog == null)
            throw new BacklogNotFoundException("Backlog Not Found!");

        return projectTaskRepository.findByProjectIdentifierOrderByPriority(backlog_id);
    }

    public ProjectTask findProjectTaskByProjectSequence(String backlog_id, String pt_id){
        //make sure we are searching on the right backlog
        Backlog backlog = backlogRepository.findByProjectIdentifier(backlog_id.toUpperCase());

        if (backlog == null)
            throw new BacklogNotFoundException("Backlog Not Found!");

        ProjectTask projectTask = projectTaskRepository.findByProjectSequence(pt_id);

        if (projectTask == null)
            throw new ProjectTaskNotFoundException("Project task with sequence " + pt_id + " not found!");

        if (!projectTask.getProjectIdentifier().equals(backlog_id))
            throw new ProjectTaskNotFoundException("Project task with sequence " + pt_id + " not found in the backlog " + backlog_id + "!");

        return projectTask;
    }
}
