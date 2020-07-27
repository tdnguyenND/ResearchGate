package com.example.ResearchGate.service;

import com.example.ResearchGate.model.ProgrammingLanguage;
import org.springframework.stereotype.Service;

@Service
public interface ProgrammingLanguageService {
    Iterable<ProgrammingLanguage> findByUserId(int userId);
    void deleteAProgrammingLanguageOfUser(int userId, String programmingLanguage);
    void deleteAllByUserId(int userId);
    <S extends ProgrammingLanguage>S save(S s);
}
