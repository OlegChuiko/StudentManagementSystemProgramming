package com.example.student_management.service;

import java.util.List;
import java.util.Optional;

import com.example.student_management.classes.Student;

public interface StudentService {
    
    List<Student> getAllStudents();
    Optional<Student> getStudentById(Long id);
    Student addStudent(Student student);
    Student updateStudent(Long id, Student student);
    void deleteStudent(Long id);
}