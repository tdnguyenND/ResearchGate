package com.example.ResearchGate.service;

import com.example.ResearchGate.model.Application;
import org.springframework.stereotype.Service;

@Service
public interface ApplicationService {
    Application save(Application app);
    Iterable<Application> findAllByRecruitmentId(Integer recruitmentId);
    Iterable<Application> findAllByStudentId(Integer studentId);
}
