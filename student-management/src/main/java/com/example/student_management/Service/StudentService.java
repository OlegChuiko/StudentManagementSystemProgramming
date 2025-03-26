package com.example.student_management.Service;

import com.example.student_management.Classes.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    
    List<Student> getAllStudents();
    Optional<Student> getStudentById(Long id);
    Student addStudent(Student student);
    Student updateStudent(Long id, Student student);
    void deleteStudent(Long id);
}