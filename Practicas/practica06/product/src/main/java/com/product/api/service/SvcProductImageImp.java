package com.product.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.product.api.dto.ApiResponse;
import com.product.api.entity.ProductImage;
import com.product.api.repository.RepoProductImage;
import com.product.exception.ApiException;

@Service
public class SvcProductImageImp implements SvcProductImage {
 
    @Autowired
    RepoProductImage repo;

    @Override
    public ApiResponse setProductImage(ProductImage in) {
        ProductImage imageSaved = repo.findByProductImageId(in.getProductImageId());
        if (imageSaved != null) {
            if (imageSaved.getStatus() == 0) {
                repo.activateProductImage(in.getStatus());
                return new ApiResponse("product image created");
            } else {
                throw new ApiException(HttpStatus.BAD_REQUEST, "product image can not be created");
            }
        }
        repo.createProductImage(in.getProductImageId(), in.getImage());
        return new ApiResponse("product image created");
    }
}
