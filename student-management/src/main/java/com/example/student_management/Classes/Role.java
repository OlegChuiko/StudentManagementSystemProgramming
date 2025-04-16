package com.example.student_management.Classes;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.GeneratedValue;


@Entity
public class Role {
    @Id @GeneratedValue
    private Long id;
    private String name;
}

