package com.sd17318.assigment1.service;

import com.sd17318.assigment1.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();

    Category findById(int id);
}
