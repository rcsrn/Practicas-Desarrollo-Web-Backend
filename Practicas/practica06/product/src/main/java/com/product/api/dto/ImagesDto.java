package com.product.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImagesDto {
    
    private Integer product_image_id;
    private Integer product_id;
    private String image;
    
    public ImagesDto(Integer product_image_id, Integer product_id, String image) {
        this.product_image_id = product_image_id;
        this.product_id = product_id;
        this.image = image;
    }

    public Integer getProductImageId() {
        return product_id;
    }

    public void setProductImageId(Integer product_image_id) {
        this.product_image_id = product_image_id;
    }

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
