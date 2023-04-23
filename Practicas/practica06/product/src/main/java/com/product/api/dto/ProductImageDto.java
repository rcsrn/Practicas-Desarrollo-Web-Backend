package com.product.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductImageDto {
    
    @JsonProperty("product_id")
    private Integer product_id;
    @JsonProperty("image")
    private String image;

    public Integer getProductId() {
        return product_id;
    }

    public void setProductId(Integer product_id) {
        this.product_id = product_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
