package com.example.ResearchGate.service.impl;

import com.example.ResearchGate.Repository.StudentRepository;
import com.example.ResearchGate.model.Student;
import com.example.ResearchGate.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository repository;

    @Override
    public Optional<Student> findByUserId(Integer userId) {
        return repository.findById(userId);
    }

    @Override
    public void updateInformation(Student student) {
        repository.deleteById(student.userId);
        repository.save(student);
    }

    @Override
    public <S extends Student> S save(S s) {
        return repository.save(s);
    }
}
