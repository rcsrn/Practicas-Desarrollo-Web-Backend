package com.product.api.service;

import java.util.List;


import com.product.api.dto.ApiResponse;
import com.product.api.dto.ProductImageDto;
import com.product.api.entity.ProductImage;

public interface SvcProductImage {
    ApiResponse createProductImage(ProductImageDto in);

    List<ProductImage> getProductImages(Integer product_id);

    ApiResponse deleteProductImage(Integer product_image_id);
}
