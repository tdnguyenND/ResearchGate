package com.example.ResearchGate.service.impl;

import com.example.ResearchGate.Repository.ApplicationRepository;
import com.example.ResearchGate.model.Application;
import com.example.ResearchGate.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    ApplicationRepository repository;

    @Override
    public Application save(Application app) {
        return repository.save(app);
    }

    @Override
    public Iterable<Application> findAllByRecruitmentId(Integer recruitmentId) {
        return repository.findAllByRecruitmentId(recruitmentId);
    }

    @Override
    public Iterable<Application> findAllByStudentId(Integer studentId) {
        return repository.findAllByStudentId(studentId);
    }
}
