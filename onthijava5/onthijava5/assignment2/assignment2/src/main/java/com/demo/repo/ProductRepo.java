package com.demo.repo;

import com.demo.model.Category;
import com.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Query(value = "select * from Products p where p.price between ?1 and ?2 and p.name like ?3 and p.Categoryid like ?4",nativeQuery = true)
    Page<Product> search(int min, int max, String name, Category category,Pageable pageable);



}
