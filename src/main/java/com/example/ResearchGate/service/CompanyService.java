package com.example.ResearchGate.service;

import com.example.ResearchGate.model.Company;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CompanyService {
    Optional<Company> findById(Integer userId);
    <S extends Company> S save(S s);
    void updateInfo(Company company);
}
