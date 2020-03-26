package com.alibubu.personalkanbantool.repositories;

import com.alibubu.personalkanbantool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


//Crud offers easy CRUD operation
@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    @Override
    public Iterable<Project> findAllById(Iterable<Long> iterable);

    public Project findByProjectIdentifier(String projectIdentifier);

}
