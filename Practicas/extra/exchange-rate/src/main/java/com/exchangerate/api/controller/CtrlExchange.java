package com.exchangerate.api.controller;

import java.lang.StringBuilder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.exchangerate.api.dto.ApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/rate")
public class CtrlExchange {

    @Value("${api.base-url}")
    String url;
    
    @GetMapping("/{currency}")
    public ResponseEntity<String> getRate(@PathVariable String currency) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> response = template.getForEntity(url + currency, String.class);
        
        ObjectMapper mapper = new ObjectMapper();
        try {
        ApiResponse rate = mapper.readValue(response.getBody(), ApiResponse.class);
        return new ResponseEntity<>(rate.toString(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("currency has not been found", HttpStatus.NOT_FOUND);
        }
    }
}
