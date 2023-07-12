package com.sd17318.assigment1.service.impl;

import com.sd17318.assigment1.model.Category;
import com.sd17318.assigment1.model.Product;
import com.sd17318.assigment1.service.CategoryService;
import com.sd17318.assigment1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    List<Product> productList = new ArrayList<>();

    @Autowired
    CategoryService categoryService;

    Category category1 = categoryService.findById(1);
    Category category2 = categoryService.findById(2);

    @Override
    public List<Product> getAll() {
        productList.add(new Product(1, "a", category1, 23));
        productList.add(new Product(2, "b", category2, 24));
        productList.add(new Product(3, "c", category1, 25));
        productList.add(new Product(4, "d", category2, 26));
        return productList;
    }

    @Override
    public void addProduct(Product product) {
        int id = 1;
        if (productList.size() > 0) {
            id = productList.get(productList.size() - 1).getId() + 1;
        }

        product.setId(id);

        if (product.getCategory() != null) {
            Category category = categoryService.findById(product.getCategory().getId());
            product.setCategory(category);
        }

        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        Product viTri = findById(id);
        productList.remove(viTri);
    }

    @Override
    public int viTri(List<Product> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Product update(List<Product> list, int id) {
        int viTri = viTri(list, id);
        return productList.get(viTri);
    }
}
