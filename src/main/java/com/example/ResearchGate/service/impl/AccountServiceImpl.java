package com.example.ResearchGate.service.impl;

import com.example.ResearchGate.Repository.AccountRepository;
import com.example.ResearchGate.model.Account;
import com.example.ResearchGate.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository repository;
    @Override
    public Optional<Account> findAccountByUsername(String username) {
        return repository.findAccountByUsername(username);
    }

    @Override
    public <S extends Account> S save(S s) {
        return repository.save(s);
    }
}
