package com.example.demo.service;

import com.example.demo.entity.HangKhachHang;
import com.example.demo.entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface KhachHangService {

    Page<KhachHang> getAll(Pageable pageable);

    Page<KhachHang> search(String timKiem, HangKhachHang hangKhachHang, Pageable pageable);

}
