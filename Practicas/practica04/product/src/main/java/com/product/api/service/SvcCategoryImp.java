package com.product.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.product.api.entity.Category;
import com.product.api.repository.RepoCategory;

public class SvcCategoryImp implements SvcCategory {

    @Autowired
    RepoCategory repo;

    @Override public List<Category> getCategories() {
        return repo.findByStatus(1);
    }
     
    @Override public Category getCategory(Integer category_id) {
        return repo.findByCategoryId(category_id);
    }   
    
    @Override public String createCategory(Category category) {
        Category categorySaved = (Category) repo.findByCategory(category.getCategory());
        if (categorySaved != null) {
            if (categorySaved.getStatus() == 0) {
                repo.activateCategory(categorySaved.getCategoryId());
                return "category has been activated";
                } else {
                    return "category already exists";
                }
        }
        repo.createCategory(category.getCategory(), category.getAcronym());
        return "category created";
    }

    @Override public String updateCategory(Integer category_id, Category category) {
        Category categorySaved = repo.findByCategoryId(category_id);

        if (categorySaved != null) {
            if (categorySaved.getCategoryId() != 0) {
                
                categorySaved = (Category) repo.findByCategory(category.getCategory());
                if (categorySaved != null) {
                    return "category already exists";
                }

                repo.updateCategory(category_id, category.getCategory(), category.getAcronym());
                return "category updated";

            } else {
                return "category is not active";
            } 
        } else {
            return "category does not exist";
        }
    }

    @Override public String deleteCategory(Integer category_id) {
        return null;
    }
}