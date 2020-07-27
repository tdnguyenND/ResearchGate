package com.example.ResearchGate.Repository;

import com.example.ResearchGate.model.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, String> {
    Optional<Account> findAccountByUsername(String username);
}
