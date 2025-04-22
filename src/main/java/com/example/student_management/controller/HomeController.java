package com.example.student_management.controller;

import com.example.student_management.classes.Student;
import com.example.student_management.service.StudentService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {

    private final StudentService studentService;

    // Constructor injection
    public HomeController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/home")
    public String home(Model model, Principal principal) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        if (principal != null) {
            model.addAttribute("username", principal.getName());
        }
        return "home"; // Повертає Thymeleaf-шаблон home.html
    }
}