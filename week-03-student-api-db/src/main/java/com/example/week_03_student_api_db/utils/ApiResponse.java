package com.example.week_03_student_api_db.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ApiResponse<T> {
    private int status;
    private String message;
    private T data;

    public static <T> ApiResponse<T> success(String message, T data){
        return new ApiResponse<>(HttpStatus.OK.value(), message, data);
    }

    public static <T> ApiResponse<T> created(String message, T data){
        return new ApiResponse<>(HttpStatus.CREATED.value(), message, data);
    }

    public static <T> ApiResponse<T> error(HttpStatus status, String message){
        return new ApiResponse<>(status.value(), message, null);
    }
}
