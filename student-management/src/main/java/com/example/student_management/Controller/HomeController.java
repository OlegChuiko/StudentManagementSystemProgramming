package com.example.student_management.Controller;

import com.example.student_management.Classes.Student;
import com.example.student_management.Classes.User;
import com.example.student_management.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final StudentService studentService;

    @GetMapping("/home")
    public String home(Model model, Principal principal) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        System.out.println("Home"+ students.toString());
        // Симуляція отримання авторизованого користувача
        // User loggedInUser = new User(1L, principal.getName(), Set.of()); // Приклад без ролей
        //model.addAttribute("user", loggedInUser);

        return "home"; // Повертає Thymeleaf-шаблон home.html
    }
}