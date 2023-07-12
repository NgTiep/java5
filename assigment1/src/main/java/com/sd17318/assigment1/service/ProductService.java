package com.sd17318.assigment1.service;

import com.sd17318.assigment1.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    void addProduct(Product product);

    Product findById(int id);

    void delete(int id);

    int viTri(List<Product>list, int id);

    Product update(List<Product>list, int id);
}


