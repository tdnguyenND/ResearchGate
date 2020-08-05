package com.example.ResearchGate.service;

import com.example.ResearchGate.model.Company;
import org.springframework.stereotype.Service;

@Service
public interface CompanyService {
    <S extends Company> S save(S s);
}
