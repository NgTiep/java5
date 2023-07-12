package com.sd17318.tiepnmph25816.service.impl;

import com.sd17318.tiepnmph25816.entity.Product;
import com.sd17318.tiepnmph25816.repository.ProductRepository;
import com.sd17318.tiepnmph25816.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public void add(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product getOne(long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public int viTri(List<Product> list, long id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<Product> searchName(List<Product> list, String categoryName) {
        return productRepository.searchName(list,categoryName);
    }
}
