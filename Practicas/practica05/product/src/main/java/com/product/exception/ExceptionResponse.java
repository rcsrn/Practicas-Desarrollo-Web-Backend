package com.product.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {
    private LocalDateTime timestamp;
    private Integer status;
    private HttpStatus error;
    private String message;
    private String path;

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public LocalDateTime getTimeStamp() {
        return timestamp;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public Integer getStatus() {
        return status;
    }

    public void setError(HttpStatus error) {
        this.error = error;
    }

    public HttpStatus geHttpStatus() {
        return error;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    
    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
    
}