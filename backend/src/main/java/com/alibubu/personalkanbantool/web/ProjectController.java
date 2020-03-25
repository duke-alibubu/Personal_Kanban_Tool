package com.alibubu.personalkanbantool.web;

import com.alibubu.personalkanbantool.domain.Project;
import com.alibubu.personalkanbantool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;


    //BindingResult: basically it analyzes the object & it determines whether or not there are errors
    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return new ResponseEntity<>("Invalid Project Object!", HttpStatus.BAD_REQUEST);
        }

        Project createdProject = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }


}
