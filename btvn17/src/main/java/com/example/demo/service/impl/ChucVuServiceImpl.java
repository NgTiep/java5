package com.example.demo.service.impl;

import com.example.demo.entity.ChucVu;
import com.example.demo.repository.ChucVuRepo;
import com.example.demo.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChucVuServiceImpl implements ChucVuService {

    @Autowired
    ChucVuRepo chucVuRepo;

    @Override
    public List<ChucVu> getAll() {
        return chucVuRepo.findAll();
    }

    @Override
    public ChucVu getOne(UUID id) {
        return chucVuRepo.findById(id).get();
    }
}
