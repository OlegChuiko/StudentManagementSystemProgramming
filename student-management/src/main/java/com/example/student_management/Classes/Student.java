package com.example.student_management.Classes;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Long id;

    @NotNull(message = "Ім'я не може бути порожнім")
    @Size(min = 2, max = 50, message = "Ім'я має бути від 2 до 50 символів")
    private String name;

    @Min(value = 18, message = "Вік має бути не менше 18 років")
    @Max(value = 100, message = "Вік має бути не більше 100 років")
    private int age;
}