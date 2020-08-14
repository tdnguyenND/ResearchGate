package com.example.ResearchGate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "application")
public class Application {
    @Id
    public Integer id;

    @Column(name = "student_id")
    public Integer studentId;

    @Column(name = "recruitment_id")
    public Integer recruitmentId;

    public String experience;

    @Column(name = "foreign_language")
    public String foreignLanguage;

    @Column(name = "social_activities")
    public String socialActivities;

    @Column(name = "special_skills")
    public String specialSkills;

    @Column(name = "career_objective")
    public String careerObjective;
}
