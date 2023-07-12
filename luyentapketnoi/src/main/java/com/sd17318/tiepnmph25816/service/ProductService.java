package com.sd17318.tiepnmph25816.service;

import com.sd17318.tiepnmph25816.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    void add(Product product);

    void update(Product product);

    void delete(long id);

    Product getOne(long id);

    int viTri(List<Product>list, long id);

    List<Product> searchName(List<Product>list, String categoryName);
}
