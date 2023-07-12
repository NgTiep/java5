package com.demo.repo;

import com.demo.model.Product;
import com.demo.model.Report;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Integer>{
    List<Product> findByName(String name);
    List<Product> findByNameLike(String keyword);
    List<Product> findByCategoryIdAndNameLike(int cid, String keyword);

    //@Query("SELECT p FROM Product p WHERE p.category.id=?1 AND p.name LIKE ?2")
    @Query(value = "SELECT * FROM product WHERE category_id=?1 AND name LIKE ?2", nativeQuery = true)
    List<Product> searchProduct(int cid, String keyword, Pageable pageable);

    @Query("SELECT new Report(p.category.id, COUNT(1)) FROM Product p GROUP BY p.category.id")
    List<Report> getReport();
}
