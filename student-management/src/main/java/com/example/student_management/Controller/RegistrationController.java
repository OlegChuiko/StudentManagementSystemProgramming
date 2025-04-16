package com.example.student_management.Controller;
import com.example.student_management.Classes.*;
import com.example.student_management.Repository.RoleRepository;
import com.example.student_management.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register"; // назва HTML-шаблону (register.html)
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);

        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(Set.of(userRole));

        userRepository.save(user);
        return "redirect:/login";
    }
}

