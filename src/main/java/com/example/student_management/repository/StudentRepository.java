package com.example.student_management.repository;

import org.springframework.stereotype.Repository;

import com.example.student_management.classes.Student;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    
    private final List<Student> students = new ArrayList<>();

    public StudentRepository() {
        // Додаємо тестових студентів
        students.add(new Student(1L, "Іван", 20));
        students.add(new Student(2L, "Марія", 22));
        students.add(new Student(3L, "Петро", 19));
    }

    // Отримати всіх студентів
    public List<Student> getAllStudents() {
        return students;
    }

    // Додати нового студента
    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }
}