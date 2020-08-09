package com.example.ResearchGate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@entity
@Table(name="recruiment")
public class Recruiment{
    @Id
    public Integer Id;

    public String career;

    public Integer amount;

    public String salary;

    public String requirement;

    public String advantage;

    @Column(name="type_of_work")
    public String typeofwork;

}