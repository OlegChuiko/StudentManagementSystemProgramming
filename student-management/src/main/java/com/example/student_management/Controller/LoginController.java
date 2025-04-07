package com.example.student_management.Controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage() {
        // Якщо користувач вже аутентифікований, перенаправляємо на головну сторінку
        if (SecurityContextHolder.getContext().getAuthentication() != null && 
            SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            return "redirect:/home"; // або інший шлях для вже аутентифікованого користувача
        }
        return "login"; // Показуємо сторінку входу, якщо користувач не аутентифікований
    }
}

