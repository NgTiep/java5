package com.poly.hangnt169.B9_JPA.service.impl;

import com.poly.hangnt169.B9_JPA.entity.Category;
import com.poly.hangnt169.B9_JPA.repository.CategoryRepository;
import com.poly.hangnt169.B9_JPA.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component // Danh dau 1 class Bean
// De dung cau truc Spring 3 layer(cau truc 3 tang)
@Service
public class CategoryServiceImpl implements CategoryService {

    // Goi bean => Goi tang repository
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll(); // SELECT * FROM ...
    }

    @Override
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> search1(String categoryName, Long id) {
        return categoryRepository.search1(id, categoryName);
    }
    // Get all => findAll
    // Them => save
    // Update => save
    // xoa => deleteById
}
