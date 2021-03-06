package com.example.ResearchGate.Repository;

import com.example.ResearchGate.model.Recruitment;
import org.springframework.data.repository.CrudRepository;

public interface RecruitmentRepository extends CrudRepository<Recruitment, Integer> {
    Iterable<Recruitment> findAllByLanguage(String requirement);
    Iterable<Recruitment> findAllByUserId(Integer userId);

}