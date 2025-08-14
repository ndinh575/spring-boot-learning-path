package com.example.week_02_student_api_inmemory.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class StudentDTO {
    @NotNull
    @Size(min = 2, message = "Name must be at least 2 characters")
    private String name;

    private int age;
    private String email;

    public StudentDTO() {
    }

    public StudentDTO(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
