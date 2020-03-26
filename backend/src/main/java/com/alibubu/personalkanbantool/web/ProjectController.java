package com.alibubu.personalkanbantool.web;

import com.alibubu.personalkanbantool.domain.Project;
import com.alibubu.personalkanbantool.services.MapValidationErrorService;
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

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    //BindingResult: basically it analyzes the object & it determines whether or not there are errors
    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult bindingResult){
        ResponseEntity<?> errorMap = mapValidationErrorService.retrieveErrorMap(bindingResult);
        if (errorMap != null)
            return errorMap;     //the typo-error which is not associated with the database can be handled from the Controller level.

        Project createdProject = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
    }


}
