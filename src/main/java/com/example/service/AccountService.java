package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Account;
import com.example.repository.AccountRepository;

@Service
@Transactional
public class AccountService {

    AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public boolean checkAccount(Integer accountId){
        return accountRepository.existsByAccountId(accountId);
    }

    public boolean checkDuplication(Account account){
        return accountRepository.existsByUsername(account.getUsername());
    }

    public Account addAccount(Account account){
        return accountRepository.save(account);
    }

    public Account verifyAccount(Account account){
        return accountRepository.findAccountByUsernameAndPassword(account.getUsername(), account.getPassword());
    }

}
