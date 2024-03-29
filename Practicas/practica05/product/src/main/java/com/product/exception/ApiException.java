package com.product.exception;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException{
    private HttpStatus status;

    public ApiException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    } 

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;        
    }
}


