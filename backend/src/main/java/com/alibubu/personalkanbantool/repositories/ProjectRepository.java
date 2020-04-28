package com.alibubu.personalkanbantool.repositories;

import com.alibubu.personalkanbantool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


//Crud offers easy CRUD operation
@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    public Project findByProjectIdentifier(String projectIdentifier);

}
