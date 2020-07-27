package com.example.ResearchGate.service;

import com.example.ResearchGate.model.ProgrammingLanguage;
import org.springframework.stereotype.Service;

@Service
public interface ProgrammingLanguageService {
    Iterable<ProgrammingLanguage> findByUserId(Integer userId);
    void deleteById(Integer userId, String programmingLanguage);
    void deleteAllByUserId(Integer userId);
    <S extends ProgrammingLanguage>S save(S s);
}
