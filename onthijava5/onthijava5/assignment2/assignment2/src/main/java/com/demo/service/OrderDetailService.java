package com.demo.service;

import com.demo.model.OrderDetail;
import com.demo.repo.OrderDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {

    @Autowired
    OrderDetailRepo  orderDetailRepo;

    public List<OrderDetail> getAll(){
        return orderDetailRepo.findAll();
    }

    public void delete(Long id){
         orderDetailRepo.deleteById(id);
    }

}
