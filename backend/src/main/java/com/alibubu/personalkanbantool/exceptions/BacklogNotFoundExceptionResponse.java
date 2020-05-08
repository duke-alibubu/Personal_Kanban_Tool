package com.alibubu.personalkanbantool.exceptions;

public class BacklogNotFoundExceptionResponse {
    private String projectNotFound;

    public BacklogNotFoundExceptionResponse(String projectNotFound) {
        this.projectNotFound = projectNotFound;
    }

    public String getProjectNotFound() {
        return projectNotFound;
    }

    public void setProjectNotFound(String projectNotFound) {
        this.projectNotFound = projectNotFound;
    }
}
