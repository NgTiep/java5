package com.example.btvn15.service;

import com.example.btvn15.entity.TaiKhoan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface TaiKhoanService {

    Page<TaiKhoan> getAll(Pageable pageable);

    TaiKhoan getOne(UUID id);

    void add(TaiKhoan taiKhoan);

    void delete(UUID id);

    void update(TaiKhoan taiKhoan);

    Page<TaiKhoan> search(String ten,Pageable pageable);

    Page<TaiKhoan> hoaDong(Pageable pageable);

    Page<TaiKhoan> sapXep(Pageable pageable);


}
