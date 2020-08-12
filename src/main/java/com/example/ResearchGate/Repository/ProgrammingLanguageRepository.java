package com.example.ResearchGate.Repository;

import com.example.ResearchGate.model.PLKey;
import com.example.ResearchGate.model.ProgrammingLanguage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProgrammingLanguageRepository extends CrudRepository<ProgrammingLanguage, PLKey> {
    Iterable<ProgrammingLanguage> findAllByUserId(Integer userId);

    void deleteAllByUserId(Integer userId);

    @Query("select distinct programmingLanguage from ProgrammingLanguage")
    Iterable<String> findAllProgrammingLanguage();
}
