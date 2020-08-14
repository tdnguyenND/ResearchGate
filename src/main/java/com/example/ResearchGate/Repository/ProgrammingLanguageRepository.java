package com.example.ResearchGate.Repository;

import com.example.ResearchGate.model.PLKey;
import com.example.ResearchGate.model.ProgrammingLanguage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ProgrammingLanguageRepository extends CrudRepository<ProgrammingLanguage, PLKey> {
    Iterable<ProgrammingLanguage> findAllByUserId(Integer userId);

    @Transactional
    void deleteAllByUserId(Integer userId);
}
