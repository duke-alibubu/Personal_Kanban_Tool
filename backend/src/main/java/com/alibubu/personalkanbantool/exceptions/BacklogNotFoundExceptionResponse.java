package com.alibubu.personalkanbantool.exceptions;

public class BacklogNotFoundExceptionResponse {
    private String backlogNotFound;

    public BacklogNotFoundExceptionResponse(String projectNotFound) {
        this.backlogNotFound = projectNotFound;
    }

    public String getProjectNotFound() {
        return backlogNotFound;
    }

    public void setProjectNotFound(String projectNotFound) {
        this.backlogNotFound = projectNotFound;
    }
}
