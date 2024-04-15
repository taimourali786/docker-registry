package com.example.jpapractice.jpa.student.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(schema = "jpa", name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private int age;
}