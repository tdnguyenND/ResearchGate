package com.example.ResearchGate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "user_id")
    public Integer userId;

    @Column(name = "first_name")
    public String firstName;

    @Column(name = "last_name")
    public String lastName;

    public String address;

    @Column(name = "date_of_birth")
    public String dateOfBirth;

    public String gender;

    @Column(name = "phone_number")
    public String phoneNumber;

    public String email;

    @Column(name = "academic_level")
    public String academicLevel;

    @Column(name = "training_place")
    public String trainingPlace;

    public String achievement;
    public String forte;
    public String hobbits;

}
