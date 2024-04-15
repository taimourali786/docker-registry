package com.example.jpapractice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private int age;
}
