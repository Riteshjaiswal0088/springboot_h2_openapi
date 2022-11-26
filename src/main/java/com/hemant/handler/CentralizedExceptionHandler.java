package com.hemant.handler;

import com.hemant.exception.EmpNotFoundException;
import com.hemant.model.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CentralizedExceptionHandler {

    @ExceptionHandler(EmpNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> exceptionHandler(EmpNotFoundException exception){
        ErrorResponse response = ErrorResponse.builder().errorMessage(exception.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
