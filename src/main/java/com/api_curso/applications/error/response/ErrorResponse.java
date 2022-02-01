package com.api_curso.applications.error.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private LocalDateTime date;
    private String message;

    public ErrorResponse(LocalDateTime date, String message) {
        this.date = date;
        this.message = message;
    }
}
