package com.example.ResearchGate.model;

import javax.persistence.*;

@Entity
@Table(name = "programminglanguage")
@IdClass(PLKey.class)
public class ProgrammingLanguage {
    @Id
    @Column(name = "user_id")
    public Integer userId;

    @Id
    @Column(name = "programming_language")
    public String programmingLanguage;
}
