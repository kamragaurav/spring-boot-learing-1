package com.yash.service;

import com.yash.domain.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class StudentService {

    ArrayList<Student> students = new ArrayList<Student>(Arrays.asList(new Student(1, "Gaurav", "Ratlam"), new Student(2, "Monu", "Indore"), new Student(3, "Aadi", "Pune")));

    public ArrayList<Student> getStudents() {
        return students;
    }

    public Student getStudent(int id) {
        return students.stream().filter(student->student.getId()==id).findFirst().get();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int id) {
        students.remove(students.stream().filter(student->student.getId()==id).findFirst().get());
    }

    public void updateStudent(Student stdent) {
        int id =stdent.getId();
        students.set(stdent.getId(),students.stream().filter(student->student.getId()==id).findFirst().get());
    }
}
