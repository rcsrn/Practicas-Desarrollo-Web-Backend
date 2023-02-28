package com.product.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer category_id;
    
    @NotNull
    @Column(name = "category")
    private String category;
    
    @NotNull
    @Column(name = "acronym")
    private String acronym;
    
    @Column(name = "status")
    @Min(value = 0, message = "status must be 0 or 1")
    @Max(value = 1, message = "status must be 0 or 1")
    private Integer status;


    public Category() {}

    public void setCategoryId(Integer category_id) {
        this.category_id = category_id;
    }
    
    public Integer getCategoryId() {
        return category_id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
    
    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getAcronym() {
        return acronym;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }    

    public Integer getStatus() {
        return status;
    }
}
