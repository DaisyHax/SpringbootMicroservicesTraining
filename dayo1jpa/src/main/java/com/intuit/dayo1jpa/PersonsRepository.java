package com.intuit.dayo1jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonsRepository extends CrudRepository<Persons, Integer> {

}
