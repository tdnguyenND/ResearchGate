package com.example.ResearchGate.service.impl;

import com.example.ResearchGate.Repository.RecruitmentRepository;
import com.example.ResearchGate.model.Recruitment;
import com.example.ResearchGate.service.RecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecruitmentServiceImpl implements RecruitmentService {
    @Autowired
    RecruitmentRepository repository;

    @Override
    public Optional<Recruitment> findById(Integer userId) {
        return repository.findById(userId);
    }

    @Override
    public <S extends Recruitment> S save(S s) {
        return repository.save(s);
    }

    @Override
    public Iterable<Recruitment> findAll() {
        return repository.findAll();
    }

    @Override
    public Iterable<Recruitment> findByRequirement(String skill) {
        return repository.findAllByRequirement(skill);
    }
}