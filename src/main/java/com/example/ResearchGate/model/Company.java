package com.example.ResearchGate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @Column(name = "user_id")
    public Integer userId;

    @Column(name = "name_company")
    public String nameCompany;

    public String address;

    @Column(name = "hotlines")
    public String hotlines;

    public String email;
}