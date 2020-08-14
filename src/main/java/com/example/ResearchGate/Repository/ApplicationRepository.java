package com.example.ResearchGate.Repository;

import com.example.ResearchGate.model.Application;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationRepository extends CrudRepository<Application, Integer> {
    Iterable<Application> findAllByRecruitmentId(Integer recruitmentId);

    Iterable<Application> findAllByStudentId(Integer studentId);
}
