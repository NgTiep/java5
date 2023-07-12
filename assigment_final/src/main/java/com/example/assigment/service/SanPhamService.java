package com.example.assigment.service;

import com.example.assigment.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface SanPhamService {

    Page<SanPham> getAll(Pageable pageable);

    SanPham getOne(UUID id);

    void add(SanPham sanPham);

    void update(SanPham sanPham);

    void delete(UUID id);
}
