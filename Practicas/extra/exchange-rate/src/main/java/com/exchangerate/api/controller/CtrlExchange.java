package com.exchangerate.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.exchangerate.api.dto.ApiResponse;


@RestController
@RequestMapping("/rate")
public class CtrlExchange {
    

    @GetMapping("/{currency}")
    public ResponseEntity<ApiResponse> getRate() {
        return null;
    }
}
