package com.example.btvn15.service.impl;

import com.example.btvn15.entity.ChucVu;
import com.example.btvn15.repository.ChucVuRepository;
import com.example.btvn15.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChucVuServiceImpl implements ChucVuService {

    @Autowired
    ChucVuRepository chucVuRepository;

    @Override
    public List<ChucVu> getAll() {
        return chucVuRepository.findAll();
    }

    @Override
    public ChucVu getOne(UUID id) {
        return chucVuRepository.findById(id).get();
    }
}
