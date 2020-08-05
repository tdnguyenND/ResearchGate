package com.example.ResearchGate.service.impl;

import com.example.ResearchGate.Repository.CompanyRepository;
import com.example.ResearchGate.model.Company;
import com.example.ResearchGate.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository repository;
    @Override
    public <S extends Company> S save(S s) {
        return repository.save(s);
    }
}
