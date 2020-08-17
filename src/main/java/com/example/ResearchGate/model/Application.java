package com.example.ResearchGate.model;

import javax.persistence.*;

@Entity(name = "application")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "student_id")
    public Integer studentId;

    @Column(name = "recruitment_id")
    public Integer recruitmentId;

    public String experience;

    @Column(name = "social_activities")
    public String socialActivities;

    @Column(name = "special_skills")
    public String specialSkills;

    @Column(name = "career_objective")
    public String careerObjective;
}
