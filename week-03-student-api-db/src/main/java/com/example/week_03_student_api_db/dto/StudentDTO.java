package com.example.week_03_student_api_db.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    @NotNull
    @Size(min = 2, message = "Name must be at least 2 characters")
    private String name;

    @Min(value = 1, message = "Age must be greater than 0")
    private int age;

    @Email(message = "Email should be valid")
    private String email;

}
