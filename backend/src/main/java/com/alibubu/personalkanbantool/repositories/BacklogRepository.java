package com.alibubu.personalkanbantool.repositories;

import com.alibubu.personalkanbantool.domain.Backlog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacklogRepository extends CrudRepository<Backlog, Long> {
}
