package com.example.jpapractice.jpa.student.repository;

import com.example.jpapractice.jpa.student.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
}
