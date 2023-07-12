package com.poly.hangnt169.B9_JPA.service;

import com.poly.hangnt169.B9_JPA.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();

    void addCategory(Category category);

    void updateCategory(Category category);

    void deleteCategory(Long id);

    List<Category>search1(String categoryName,Long id);

}
