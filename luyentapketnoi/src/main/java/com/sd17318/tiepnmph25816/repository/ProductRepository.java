package com.sd17318.tiepnmph25816.repository;

import com.sd17318.tiepnmph25816.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM Product c WHERE c.product_name like ?1",nativeQuery = true)
    List<Product> searchName(List<Product>list, String categoryName);

}
