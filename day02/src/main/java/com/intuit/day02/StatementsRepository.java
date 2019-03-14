package com.intuit.day02;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatementsRepository extends CrudRepository<Statements, Integer> {
}
