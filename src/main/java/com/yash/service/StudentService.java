package com.yash.service;

import com.yash.domain.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

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
        int bound = students.size();
        for (int i = 0; i < bound; i++) {
            Student student = students.get(i);
            if (stdent.getId() == student.getId()) {
                students.set(i, stdent);
            }
        }
    }
}
