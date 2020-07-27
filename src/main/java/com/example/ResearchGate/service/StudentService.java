package com.example.ResearchGate.service;

import com.example.ResearchGate.model.Student;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface StudentService {
    Optional<Student> findByUserId(Integer userId);
    void updateInformation(Student student);
    <S extends Student> S save(S s);
}
