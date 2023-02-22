package com.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/category")
public class CtrlProduct {

  @GetMapping
  public String getCategories() {
    return "";
  }
}