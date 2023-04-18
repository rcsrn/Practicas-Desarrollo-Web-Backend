package com.product.api.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.product.api.entity.ProductImage;

public interface RepoProductImage extends JpaRepository<ProductImage, Integer> {
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO product_image (product_id, image, status) VALUES (:product_id, :image, 1)", nativeQuery = true)
    void createProductImage(@Param("product_id") Integer product_id, @Param("image") String image);
}
