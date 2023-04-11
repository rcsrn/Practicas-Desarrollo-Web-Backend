package com.exchangerate.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.exchangerate.api.dto.ApiResponse;


@RestController
@RequestMapping("/rate")
public class CtrlExchange {
    


    @GetMapping("/{currency}")
    public ResponseEntity<String> getRate(@PathVariable String currency) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> response = template.getForEntity("https://api.coincap.io/v2/rates/" + currency, String.class);
        return response;
    }
}
