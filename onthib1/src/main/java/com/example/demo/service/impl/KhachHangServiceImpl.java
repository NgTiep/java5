package com.example.demo.service.impl;

import com.example.demo.entity.HangKhachHang;
import com.example.demo.entity.KhachHang;
import com.example.demo.repository.KhachHangRepo;
import com.example.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    KhachHangRepo khachHangRepo;

    @Override
    public Page<KhachHang> getAll(Pageable pageable) {
        return khachHangRepo.findAll(pageable);
    }

    @Override
    public Page<KhachHang> search(String timKiem, HangKhachHang hangKhachHang, Pageable pageable) {
        return khachHangRepo.search(timKiem,hangKhachHang,pageable);
    }
}
