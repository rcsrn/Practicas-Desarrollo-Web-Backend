package com.product.api.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.product.api.dto.ProductDto;

@Repository
public interface RepoProductDto extends JpaRepository<ProductDto, Integer>{
    @Transactional
	@Query(value = "SELECT * FROM product WHERE category_id = :category_id AND status = 1", nativeQuery = true)
	List<ProductDto> findByCategory(@Param("category_id") Integer category_id);	
}