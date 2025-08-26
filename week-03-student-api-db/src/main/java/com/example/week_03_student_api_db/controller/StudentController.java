package com.example.week_03_student_api_db.controller;

import com.example.week_03_student_api_db.dto.StudentDTO;
import com.example.week_03_student_api_db.mapper.StudentMapper;
import com.example.week_03_student_api_db.model.Student;
import com.example.week_03_student_api_db.service.StudentService;
import com.example.week_03_student_api_db.utils.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentMapper studentMapper;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getAll(){
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(
                ApiResponse.success(students.isEmpty()
                        ? "List of students is empty"
                        : "Get list of students successfully",
                        students)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getById(@PathVariable Integer id){
        return studentService.getStudentById(id)
                .map(existing -> ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(ApiResponse.created("Student found", existing))
                )
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Student>> create(@Valid @RequestBody StudentDTO dto){
        Student student = studentMapper.toEntity(dto);
        Student saved = studentService.saveStudent(student);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.created("Student created successfully", saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> update(@PathVariable Integer id, @RequestBody StudentDTO dto){
        Student student = studentMapper.toEntity(dto);
        return studentService.getStudentById(id)
                .map(existing -> {
                    student.setId(id);
                    return ResponseEntity
                            .status(HttpStatus.CREATED)
                            .body(ApiResponse.created(
                                    "Student updated successfully",
                                    studentService.saveStudent(student))
                            );
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        if(studentService.getStudentById(id).isPresent()){
            studentService.deleteStudent(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
