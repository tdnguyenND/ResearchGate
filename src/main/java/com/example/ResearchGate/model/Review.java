package com.example.ResearchGate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "review")
public class Review {
    @Id
    public Integer id;

    @Column(name = "student_id")
    public Integer studentId;

    @Column(name = "company_id")
    public Integer companyId;

    public String content;
}
