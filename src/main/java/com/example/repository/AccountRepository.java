package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

    Boolean existsByUsername(String username);
    Boolean existsByAccountId(Integer accountId);
    Account findAccountByUsernameAndPassword(String username, String password);

}
