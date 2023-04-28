package com.product.api.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.product.api.dto.ApiResponse;
import com.product.api.entity.Product;

@Repository
public interface RepoProduct extends JpaRepository<Product, Integer>{
	
	// 3. Implementar la firma de un método que permita consultar un producto por su código GTIN y con estatus 1
	@Transactional
	@Query(value = "SELECT * from product WHERE gtin = :gtin AND status = 1", nativeQuery = true)
	Product findByGtinAndStatus(@Param("gtin") String gtin);
	// --------------------------------------------

	@Transactional
	@Query(value = "SELECT * FROM product WHERE gtin = :gtin", nativeQuery = true)
	Product findByGtin(@Param("gtin") String gtin);

	@Transactional
	@Query(value = "UPDATE product SET status = 1 WHERE product_id = :product_id", nativeQuery = true)
	Product activateProduct(@Param("product_id") Integer product_id);

	@Transactional
	@Query(value = "SELECT * FROM product WHERE category_id = :category_id AND status = 1", nativeQuery = true)
	List<Product> findByCategory(@Param("category_id") Integer category_id);	

	@Transactional
	@Query(value = "SELECT * FROM product WHERE product = :product", nativeQuery = true)
	Product findByProduct(@Param("product") String product);

	@Transactional
	@Query(value = "SELECT * FROM product WHERE product_id = :product_id AND status = 1", nativeQuery = true)
	Product findByProductId(@Param("product_id") Integer product_id);

	@Modifying
	@Transactional
	@Query(value = "UPDATE product SET category_id = :category_id WHERE gtin = :gtin", nativeQuery = true)
	void updateProductCategory(@Param("gtin") String gtin, @Param("category_id") Integer category_id);

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO product (gtin, product, price, description, stock, category_id, status) VALUES (:gtin, :product, :price, :description, :stock, :category_id, 1)", nativeQuery = true)
	void createProduct(
			@Param("gtin") String gtin, 
			@Param("product") String product, 
			@Param("price") Double price,
			@Param("description") String description, 
			@Param("stock") Integer stock,
			@Param("category_id") Integer category_id);

	@Modifying
	@Transactional
	@Query(value ="UPDATE product "
					+ "SET gtin = :gtin, "
						+ "product = :product, "
						+ "description = :description, "
						+ "price = :price, "
						+ "stock = :stock, "
						+ "status = 1, "
						+ "category_id = :category_id "
					+ "WHERE product_id = :product_id", nativeQuery = true)
	Integer updateProduct(
			@Param("product_id") Integer product_id,
			@Param("gtin") String gtin, 
			@Param("product") String product, 
			@Param("description") String description, 
			@Param("price") Double price, 
			@Param("stock") Integer stock,
			@Param("category_id") Integer category_id
		);
	
	@Modifying
	@Transactional
	@Query(value ="UPDATE product SET status = 0 WHERE product_id = :product_id AND status = 1", nativeQuery = true)
	Integer deleteProduct(@Param("product_id") Integer product_id);
	
	@Modifying
	@Transactional
	@Query(value ="UPDATE product SET stock = :stock WHERE gtin = :gtin AND status = 1", nativeQuery = true)
	Integer updateProductStock(@Param("gtin") String gtin, @Param("stock") Integer stock);
}
