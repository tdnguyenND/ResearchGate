package com.example.ResearchGate.service;

import com.example.ResearchGate.model.Account;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AccountService {
    Optional<Account> findAccountByUsername(String username);
    <S extends Account> S save(S s);
}
