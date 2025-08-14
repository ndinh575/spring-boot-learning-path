package com.example.week_02_student_api_inmemory.controller;

import com.example.week_02_student_api_inmemory.dto.StudentDTO;
import com.example.week_02_student_api_inmemory.model.Student;
import jakarta.validation.Valid;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentController {

    private List<Student> students = new ArrayList<>();
    private int nextId = 1;

    @GetMapping
    public ResponseEntity<Object> getAll(){

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("status", HttpStatus.OK.value());
        response.put("message", students.isEmpty() ? "List of students is empty" : "Get list of students successfully");
        response.put("data", students);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable int id){
        Map<String, Object> response = new LinkedHashMap<>();
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .map(student -> {
                    response.put("status", HttpStatus.OK.value());
                    response.put("message", "Student found");
                    response.put("data", student);
                    return ResponseEntity.ok(response);
                })
                .orElseGet(() -> {
                    response.put("status", HttpStatus.NOT_FOUND.value());
                    response.put("message", "Student not found");
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
                });
    }

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody StudentDTO dto){
        Map<String, Object> response = new LinkedHashMap<>();
        Student student = new Student(nextId++, dto.getName(), dto.getAge(), dto.getEmail());
        students.add(student);

        response.put("status", HttpStatus.CREATED.value());
        response.put("message", "Student created successfully");
        response.put("data", student);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable int id, @Valid @RequestBody StudentDTO dto){
        Map<String, Object> response = new LinkedHashMap<>();
        for (Student s : students){
            if(s.getId() == id){
                s.setName(dto.getName());
                s.setAge(dto.getAge());
                s.setEmail(dto.getEmail());
                response.put("status", HttpStatus.OK.value());
                response.put("message", "Student updated successfully");
                response.put("data", s);
                return ResponseEntity.ok(response);
            }
        }
        response.put("status", HttpStatus.NOT_FOUND.value());
        response.put("message", "Student not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id){
        Map<String, Object> response = new LinkedHashMap<>();
        boolean removed = students.removeIf(s -> s.getId() == id);
        response.put("status", removed ? HttpStatus.OK.value() : HttpStatus.NOT_FOUND.value());
        response.put("message", removed ? "Student deleted successfully" : "Student not found");
        return  removed ? ResponseEntity.ok(response) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

}
