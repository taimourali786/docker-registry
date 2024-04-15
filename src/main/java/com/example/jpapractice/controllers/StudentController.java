package com.example.jpapractice.controllers;

import com.example.jpapractice.model.Student;
import com.example.jpapractice.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(final StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<Student> get(final @PathVariable int id) {
        return new ResponseEntity<>(this.studentService.getStudent(id), HttpStatus.OK);
    }

    @PostMapping(path = "/insert",
    consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(final @RequestBody Student student) {
        this.studentService.setStudent(student);
    }

    @PutMapping(path = "/update")
    @ResponseStatus(HttpStatus.OK)
    public void update(final @RequestBody Student student) {
        this.studentService.updateStudent(student);
    }

    @DeleteMapping(path = "/delete")
    public void delete(final @RequestBody Student student) {
        this.studentService.deleteStudent(student);
    }
}
