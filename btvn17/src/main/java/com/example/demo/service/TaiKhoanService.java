package com.example.demo.service;

import com.example.demo.entity.TaiKhoan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface TaiKhoanService {

    Page<TaiKhoan> getAll(Pageable pageable);

    TaiKhoan getOne(UUID id);

    void add(TaiKhoan taiKhoan);

    void update(TaiKhoan taiKhoan);

    void delete(UUID id);

    Page<TaiKhoan> search(String ten, Pageable pageable);

    Page<TaiKhoan> hoatDong(Pageable pageable);

    Page<TaiKhoan> sapXep(Pageable pageable);

}
