package com.example.week_03_student_api_db.mapper;

import com.example.week_03_student_api_db.dto.StudentDTO;
import com.example.week_03_student_api_db.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public Student toEntity(StudentDTO dto) {
        if (dto == null) return null;
        return new Student(null, dto.getName(), dto.getAge(), dto.getEmail());
    }

    public StudentDTO toDTO(Student student) {
        if (student == null) return null;
        return new StudentDTO(student.getName(), student.getAge(), student.getEmail());
    }
}
