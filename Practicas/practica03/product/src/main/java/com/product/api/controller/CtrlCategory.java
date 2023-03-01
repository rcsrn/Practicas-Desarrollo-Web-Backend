package com.product.api.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.api.entity.Category;


@RestController
@RequestMapping("/category")
public class CtrlCategory {

     @GetMapping
     public ResponseEntity<List<Category>> etRegions() {
          Category category1 = new Category();
          category1.setCategoryId(1);
          category1.setCategory("Línea Blanca");
          category1.setAcronym("LB");
          Category category2 = new Category();
          category2.setCategoryId(2);
          category2.setCategory("Electrónica");
          category2.setAcronym("Electr");

          List categories = new ArrayList();
          categories.add(category1);
          categories.add(category2);

          return new ResponseEntity<>(categories, HttpStatus.OK);
     };
}