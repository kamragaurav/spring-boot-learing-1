package com.yash.controller;

import com.yash.domain.Student;
import com.yash.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/students", produces = "application/json")
    public List<Student> getStudentList() {
        return studentService.getStudents();
    }

    @GetMapping(value = "/students/{studentId}")
    public Student getStudent(@PathVariable("studentId") int  id){
        return studentService.getStudent(id);
    }

    @PostMapping(value = "/students")
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @DeleteMapping(value = "/students/{studentId}")
    public void removeStudent(@PathVariable("studentId") int id){
        studentService.removeStudent(id);
    }

    public void updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
    }

}
