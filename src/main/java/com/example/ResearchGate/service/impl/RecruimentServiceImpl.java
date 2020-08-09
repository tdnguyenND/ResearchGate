package com.example.ResearchGate.service.impl;

import com.example.ResearchGate.Repository.RecruimentRepository;
import com.example.ResearchGate.model.Recruiment;
import com.example.ResearchGate.service.RecruimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecruimentServiceImpl implements RecruimentService {
    @Autowired
    RecruimentRepository repository;
    @Override
    public <S extends Recruiment> S save(S s) {
        return repository.save(s);
    }
}