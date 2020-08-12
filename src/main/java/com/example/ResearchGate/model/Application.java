package com.example.ResearchGate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="application")
public class Application {
    @Id
    @Column(name="user_id")
    public Integer userId;

    public String experience;

    @Column(name="foreign_language")
    public String foreignLanguage;

    @Column(name="social_activities")
    public String socialActivities;

    @Column(name="special_skills")
    public String specialSkills;

    @Column(name="job_goals")
    public String jobGoals;

}
