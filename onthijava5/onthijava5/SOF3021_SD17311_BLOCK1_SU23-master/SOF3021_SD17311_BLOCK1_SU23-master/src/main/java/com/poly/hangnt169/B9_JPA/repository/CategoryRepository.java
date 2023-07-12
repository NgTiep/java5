package com.poly.hangnt169.B9_JPA.repository;

import com.poly.hangnt169.B9_JPA.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // CRUD 1 bang => k can phai viet => co san CRUD 1 bang
    // Co 2 cach tu custom SQL:
    // C1: Query Creation
    // C2: Raw SQL

    // https://viblo.asia/p/spring-boot-12-spring-jpa-method-atquery-Qbq5Q4nGlD8
    // C1: Ten ham dat dung cu phap => Cang nhieu dk => Ten ham cang dai
    List<Category>findCategoryByCategoryName1AndId(String categoryName, Long id);

    // C2: Raw SQL
    // C2.1: JPQL (JPA Query Language) <=> Tuong tu gan giong HQL(Hibernate Query Language) => Truy van tren thuc te
    // native query = false (Default)
    @Query("SELECT c FROM Category c WHERE c.categoryName1 LIKE ?2 AND c.id = ?1")
    List<Category>search(Long id, String categoryName);

    // C2.2 : Native query => Truy van tren SQL
    // Native Query = true
    @Query(value = "SELECT * FROM category c WHERE c.category_name = ?2 AND c.id = ?1",nativeQuery = true)
    List<Category>search1(Long id, String categoryName);

}
