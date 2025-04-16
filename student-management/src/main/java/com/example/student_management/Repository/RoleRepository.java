package com.example.student_management.Repository;

import com.example.student_management.Classes.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // Переконайся, що є ця анотація
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}

