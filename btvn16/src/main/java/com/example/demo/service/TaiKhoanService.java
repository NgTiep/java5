package com.example.demo.service;

import com.example.demo.entity.TaiKhoan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface TaiKhoanService {

    Page<TaiKhoan> getAll(Pageable pageable);

    void add(TaiKhoan taiKhoan);

    void update(TaiKhoan taiKhoan);

    void delete(UUID id);

    TaiKhoan getOne(UUID id);
}
