package com.example.ResearchGate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="recruitment")
public class Recruitment {
    @Id
    public Integer id;

    public String career;

    public Integer amount;

    public String salary;

    public String requirement;

    public String advantage;

    @Column(name="type_of_work")
    public String typeOfWork;

}