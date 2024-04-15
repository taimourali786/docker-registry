package com.example.jpapractice.services;

import com.example.jpapractice.jpa.student.entity.StudentEntity;
import com.example.jpapractice.jpa.student.repository.StudentRepository;
import com.example.jpapractice.model.Student;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository repository;
    private final ModelMapper modelMapper;

    public StudentService(final StudentRepository repository,
                          final ModelMapper mapper) {
        this.repository = repository;
        this.modelMapper = mapper;
    }

    public void setStudent(final Student student) {
        StudentEntity entity = this.modelMapper.map(student, StudentEntity.class);
        this.repository.save(entity);
    }

    public Student getStudent(final int id) {
        Optional<StudentEntity> entity = this.repository.findById(id);
        return this.modelMapper.map(entity, Student.class);
    }

    public void updateStudent(final Student student) {
        StudentEntity entity = this.modelMapper.map(student, StudentEntity.class);
        this.repository.save(entity);
    }

    public void deleteStudent(final Student student) {
        StudentEntity entity = this.modelMapper.map(student, StudentEntity.class);
        this.repository.delete(entity);
    }
}
