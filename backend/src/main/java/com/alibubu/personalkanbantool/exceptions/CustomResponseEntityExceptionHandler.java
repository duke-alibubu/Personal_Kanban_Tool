package com.alibubu.personalkanbantool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

//controller advice helps u handle exceptions across the application, rather than being controller - specific
//like, all controller shall come here for advice - then handle the exception properly
@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleProjectIdException(ProjectIdException ex, WebRequest request){
        ProjectIdExceptionResponse projectIdExceptionResponse = new ProjectIdExceptionResponse(ex.getMessage());
        return new ResponseEntity<>(projectIdExceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
