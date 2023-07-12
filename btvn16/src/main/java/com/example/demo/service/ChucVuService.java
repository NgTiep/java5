package com.example.demo.service;

import com.example.demo.entity.ChucVu;

import java.util.List;
import java.util.UUID;

public interface ChucVuService {
    List<ChucVu> getAll();

    ChucVu getOne(UUID id);
}
