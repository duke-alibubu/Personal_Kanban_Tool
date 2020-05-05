package com.alibubu.personalkanbantool.services;

import com.alibubu.personalkanbantool.domain.Backlog;
import com.alibubu.personalkanbantool.domain.Project;
import com.alibubu.personalkanbantool.exceptions.ProjectIdException;
import com.alibubu.personalkanbantool.repositories.BacklogRepository;
import com.alibubu.personalkanbantool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private BacklogRepository backlogRepository;

    public Project saveOrUpdateProject(Project project){
        String projectIdentifier = project.getProjectIdentifier().toUpperCase();
        try {
            project.setProjectIdentifier(projectIdentifier);

            if (project.getId() == null){ //if creating a project
                Backlog backlog = new Backlog();
                project.setBacklog(backlog);
                backlog.setProject(project);
                backlog.setProjectIdentifier(projectIdentifier);
            }
            else {
                project.setBacklog(backlogRepository.findByProjectIdentifier(projectIdentifier));
            }

            return projectRepository.save(project);
        }
        catch (Exception e){

            //duplicate identifier is related to the database, so we has to do it from a service level
            throw new ProjectIdException("Project ID " + project.getProjectIdentifier().toUpperCase() + " already exists!");
        }
    }

    public Project findProjectByIdentifier(String projectIdentifier){
        Project project = projectRepository.findByProjectIdentifier(projectIdentifier.toUpperCase());

        if(project == null){
            throw new ProjectIdException("Project ID '"+projectIdentifier+"' does not exist");
        }

        return project;
    }

    public Iterable<Project> findAllProjects(){
        return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier(String projectIdentifier){
        Project project = projectRepository.findByProjectIdentifier(projectIdentifier.toUpperCase());
        if(project == null){
            throw new ProjectIdException("Project ID '"+projectIdentifier+"' does not exist, cannot delete!");
        }

        projectRepository.delete(project);
    }
}
