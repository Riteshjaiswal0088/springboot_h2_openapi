package com.hemant.model.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorResponse {
    private Integer status;
    private String errorMessage;
    private LocalDateTime dateTime;
}
