package com.product.api.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.product.api.dto.ApiResponse;
import com.product.api.dto.ProductImageDto;
import com.product.api.entity.ProductImage;
import com.product.api.repository.RepoProduct;
import com.product.api.repository.RepoProductImage;
import com.product.exception.ApiException;

@Service
@PropertySource("classpath:configuration/path.config")
public class SvcProductImageImp implements SvcProductImage {
 
    @Autowired
    RepoProductImage repo;

    @Autowired
    RepoProduct repoProduct;

    @Value("${product.images.path}")
    private String path;

    @Override
    public ApiResponse createProductImage(ProductImageDto in) {
        try {
            File folder = new File(path + in.getProductId());
            if (!folder.exists()) {
                folder.mkdir();    
            }

            String file = path + in.getProductId() + "/img_" + new Date().getTime() + ".bmp";

            byte[] data = Base64.getMimeDecoder().decode(in.getImage().substring(in.getImage().indexOf(",")+1, in.getImage().length()));

            try (OutputStream stream = new FileOutputStream(file)) { 
                stream.write(data);
            }

            in.setImage(in.getProductId() + "/img_" + new Date().getTime() + ".bmp");
            repo.createProductImage(in.getProductId(), in.getImage());
            return new ApiResponse("product image created");
        } catch (Exception e) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "product image can not be created." + e.getLocalizedMessage());
        }
    }

    @Override
    public List<ProductImage> getProductImages(Integer product_id) {
        return repo.findImagesFromProduct(product_id);
    }

    @Override
    public ApiResponse deleteProductImage(Integer product_image_id) {
        ProductImage imageSaved = repo.findByProductImageId(product_image_id);
        if (imageSaved == null || imageSaved.getStatus() == 0) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "product image cannot be deleted");
        }

        repo.deleteImage(product_image_id);
        return new ApiResponse("product image removed");
    }
}
