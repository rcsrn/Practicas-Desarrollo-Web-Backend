package com.product.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.api.dto.ApiResponse;
import com.product.api.entity.ProductImage;
import com.product.api.service.SvcProductImage;

@RestController
@RequestMapping("/product-image")
public class CtrlProductImage {
    
    @Autowired
    SvcProductImage svc;

    @GetMapping("/{product_id}")
    public ResponseEntity<ProductImage> getProductImage(@PathVariable int product_id) {
        return null;
    }    

    @PostMapping
    public ResponseEntity<ApiResponse> createProductImage(@Valid @RequestBody ProductImage in, BindingResult errors) {
        return null;
    }

    @DeleteMapping("{product_image_id}")
    public ResponseEntity<ApiResponse> deleteProductImage(@PathVariable int product_image_id) {
        return null;
    }
}
