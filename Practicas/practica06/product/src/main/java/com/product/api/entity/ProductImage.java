package com.product.api.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "product image")
public class ProductImage {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_image_id")
    private Integer product_image_id;   

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_id")
    private Product product;
    
    @NotNull
    @Column(name = "image")
    private String image;

    @Column(name = "status")
    @Min(value = 0, message = "status must be 0 or 1")
    @Max(value = 1, message = "status must be 0 or 1")
    @JsonIgnore
    private Integer status;

    public ProductImage() {
        this.image = "";
    }

    public void setProductImageId(Integer product_image_id) {
        this.product_image_id = product_image_id;
    }

    public Integer getProductImageId() {
        return product_image_id;
    }

    public void setProductId(Integer product_id) {
        product.setProduct_id(product_id);
    }

    public Integer getProductId() {
        return product.getProduct_id();
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
