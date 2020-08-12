package com.example.ResearchGate.service;

import com.example.ResearchGate.model.Recruitment;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface RecruitmentService {
    Optional<Recruitment> findById(Integer id);
    <S extends Recruitment> S save(S s);
}
