package com.example.week_03_student_api_db.repository;

import com.example.week_03_student_api_db.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByName(String name);
    List<Student> findByEmailContaining(String keyword);
}
