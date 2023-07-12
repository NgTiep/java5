package com.sd17318.assigment1.service.impl;

import com.sd17318.assigment1.model.Category;
import com.sd17318.assigment1.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    List<Category> categoryList = Arrays.asList(
            new Category(1, "Nhóm 1"),
            new Category(2, "Nhóm 2")
    );

    @Override
    public List<Category> getAll() {
        return categoryList;
    }

    @Override
    public Category findById(int id) {
        return categoryList.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .get();
    }
}
