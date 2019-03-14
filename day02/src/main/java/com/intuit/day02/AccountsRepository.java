package com.intuit.day02;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Integer> {

    //findBy Methods
    Accounts findByAccountNum(int accNum);
    Accounts findByAccountNumAndOwner(int accNum, String owner);
}
