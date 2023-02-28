package com.product;

//import java.util.LinkedList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/category")
public class CtrlProduct {

  @GetMapping
  public String getCategories() {
    for (int i = 0; i < 10; i++) {
      Category.createCategory(new Category(i, "A", "B"));
    }
    
    return Category.getCategories().toString();
  }
}