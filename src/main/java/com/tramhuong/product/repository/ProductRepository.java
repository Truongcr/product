package com.tramhuong.product.repository;

import com.tramhuong.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {


    @Query(" select p from Product p " +
            " join p.productCategoryList  pc " +
            " join pc.category c " +
            " where c.categoryId = :categoryId ")
    List<Product> findByCategoryId(UUID categoryId);
}
