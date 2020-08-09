package com.example.ResearchGate.service;

import com.example.ResearchGate.model.Recruiment;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface RecruimentService {
    Optional<Recruiment> findByUserId(Integer userId);
    <S extends Recruiment> S save(S s);
}
