package com.product.api.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.product.api.entity.ProductImage;

@Repository
public interface RepoProductImage extends JpaRepository<ProductImage, Integer> {
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO product_image (product_id, image, status) VALUES (:product_id, :image, 1)", nativeQuery = true)
    void createProductImage(@Param("product_id") Integer product_id, @Param("image") String image);

    @Transactional
    @Query(value = "SELECT * FROM product_image WHERE product_image_id = :product_image_id", nativeQuery = true)
    ProductImage findByProductImageId(@Param("product_image_id") Integer product_image_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE product_image SET status = 1 WHERE product_image_id = :product_image_id", nativeQuery = true)
    void activateProductImage(@Param("product_image_id") Integer product_image_id);
}
