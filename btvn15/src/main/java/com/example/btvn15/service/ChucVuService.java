package com.example.btvn15.service;

import com.example.btvn15.entity.ChucVu;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ChucVuService {

    List<ChucVu> getAll();

    ChucVu getOne(UUID id);
}
