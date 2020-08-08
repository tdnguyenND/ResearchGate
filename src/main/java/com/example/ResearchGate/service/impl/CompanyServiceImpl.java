package com.example.ResearchGate.service.impl;

import com.example.ResearchGate.Repository.CompanyRepository;
import com.example.ResearchGate.model.Company;
import com.example.ResearchGate.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository repository;

    @Override
    public Optional<Company> findById(Integer userId) {
        return repository.findById(userId);
    }

    @Override
    public <S extends Company> S save(S s) {
        return repository.save(s);
    }

    @Override
    public void updateInfo(Company company) {
        repository.deleteById(company.userId);
        repository.save(company);
    }
}
