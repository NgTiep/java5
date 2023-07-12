package com.demo.service;

import com.demo.model.Category;
import com.demo.model.Product;
import com.demo.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

//TODO: Connect to database
@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

    public List<Product> getAll() {
        return repo.findAll();
    }

    public void add(Product product) {
        repo.save(product);
    }

    public void update(Product product) {
        repo.save(product);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public Product getOne(Integer id) {
        return repo.findById(id).get();
    }

    public Page<Product> search(int min, int max, String name, Category category,Pageable pageable) {
        return repo.search(min, max, "%"+name+"%", category, pageable);
    }


    public Page<Product> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }


}
