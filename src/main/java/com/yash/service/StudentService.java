package com.yash.service;

import com.yash.domain.Student;
import com.yash.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Service
public class StudentService {

  //  ArrayList<Student> students = new ArrayList<Student>(Arrays.asList(new Student(1, "Gaurav", "Ratlam"), new Student(2, "Monu", "Indore"), new Student(3, "Aadi", "Pune")));

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;

    }

    public Optional<Student> getStudent(int id) {
        return studentRepository.findById(id);
    }

    public void addStudent(Student student) {
       studentRepository.save(student);

    }

    public void removeStudent(int id) {
        studentRepository.deleteById(id);
    }

    public void updateStudent(Student stdent) {
        studentRepository.save(stdent);
    }
}
