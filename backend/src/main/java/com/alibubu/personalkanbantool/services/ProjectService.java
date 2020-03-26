package com.alibubu.personalkanbantool.services;

import com.alibubu.personalkanbantool.domain.Project;
import com.alibubu.personalkanbantool.exceptions.ProjectIdException;
import com.alibubu.personalkanbantool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }
        catch (Exception e){

            //duplicate identifier is related to the database, so we has to do it from a service level
            throw new ProjectIdException("Project ID " + project.getProjectIdentifier().toUpperCase() + " already exists!");
        }
    }

    public Project findByProjectIdentifier(String projectIdentifier){
        return projectRepository.findByProjectIdentifier(projectIdentifier);
    }
}
