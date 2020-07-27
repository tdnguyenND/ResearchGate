package com.example.ResearchGate.Repository;

import com.example.ResearchGate.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
