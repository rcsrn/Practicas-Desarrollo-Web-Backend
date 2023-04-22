package com.product.api.service;

import java.util.List;

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
    public ApiResponse createProductImage(ProductImage in) {
        ProductImage imageSaved = repo.findByProductImageId(in.getProductImageId());
        if (imageSaved != null) {
            if (imageSaved.getStatus() == 0) {
                repo.activateProductImage(in.getStatus());
                return new ApiResponse("product image created");
            } else {
                throw new ApiException(HttpStatus.BAD_REQUEST, "product image can not be created");
            }
        }
        repo.createProductImage(in.getProductId(), in.getImage());
        return new ApiResponse("product image created");
    }

    public List<ProductImage> getProductImages(Integer product_id) {
        return repo.findImagesFromProduct(product_id);
    }

    public ApiResponse deleteProductImage(Integer product_image_id) {
        ProductImage imageSaved = repo.findByProductImageId(product_image_id);
        if (imageSaved == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "product image cannot be deleted");
        }
        repo.deleteImage(product_image_id);
        return new ApiResponse("product image removed");
    }
}
