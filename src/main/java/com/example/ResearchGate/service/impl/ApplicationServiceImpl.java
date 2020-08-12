package com.example.ResearchGate.service.impl;

import com.example.ResearchGate.Repository.ApplicationRepository;
import com.example.ResearchGate.model.Application;
import com.example.ResearchGate.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    ApplicationRepository repository;

    @Override
    public Optional<Application> findById(Integer userId) {
        return repository.findById(userId);
    }

    @Override
    public <S extends Application> S save(S s) {
        return repository.save(s);
    }
}
