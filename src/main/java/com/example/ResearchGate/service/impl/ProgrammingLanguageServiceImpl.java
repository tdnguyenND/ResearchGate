package com.example.ResearchGate.service.impl;

import com.example.ResearchGate.Repository.ProgrammingLanguageRepository;
import com.example.ResearchGate.model.PLKey;
import com.example.ResearchGate.model.ProgrammingLanguage;
import com.example.ResearchGate.service.ProgrammingLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgrammingLanguageServiceImpl implements ProgrammingLanguageService {

    @Autowired
    ProgrammingLanguageRepository repository;

    @Override
    public Iterable<ProgrammingLanguage> findByUserId(Integer userId) {
        return repository.findAllByUserId(userId);
    }

    @Override
    public void deleteById(Integer userId, String programmingLanguage) {
        PLKey key = new PLKey();
        key.userId = userId;
        key.programmingLanguage = programmingLanguage;
        repository.deleteById(key);
    }

    @Override
    public void deleteAllByUserId(Integer userId) {
        repository.deleteAllByUserId(userId);
    }

    @Override
    public <S extends ProgrammingLanguage> S save(S s) {
        return repository.save(s);
    }

    @Override
    public Iterable<String> findAllProgrammingLanguage() {
        return repository.findAllProgrammingLanguage();
    }
}
