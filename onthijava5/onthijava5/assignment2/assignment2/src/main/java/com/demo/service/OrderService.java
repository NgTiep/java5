package com.demo.service;

import com.demo.model.Order;
import com.demo.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepo repo;

    public List<Order> getAll() {
        return repo.findAll();
    }

    public void add(Order order) {
        repo.save(order);
    }

    public void update(Order order) {
        repo.save(order);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Order getOne(Long id) {
        return repo.findById(id).get();
    }
}
