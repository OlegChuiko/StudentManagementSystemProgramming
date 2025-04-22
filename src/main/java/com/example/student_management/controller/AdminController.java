package com.example.student_management.controller;

import com.example.student_management.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "admin/dashboard";
    }

    @GetMapping("/register")
    public String showAdminRegistrationForm() {
        return "admin/register-admin";
    }

    @PostMapping("/create-admin")
    public String createAdmin(@RequestParam String username, @RequestParam String password) {
        userService.createAdminUser(username, password);
        return "redirect:/admin/dashboard";
    }
}
 