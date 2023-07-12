package com.example.demo.service.impl;


import com.example.demo.entity.TaiKhoanNganHang;
import com.example.demo.repository.TaiKhoanNganHangRepo;
import com.example.demo.service.TaiKhoanNganHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaiKhoanNganHangServiceImpl implements TaiKhoanNganHangService {

    @Autowired
    TaiKhoanNganHangRepo taiKhoanNganHangRepo;

    @Override
    public Page<TaiKhoanNganHang> getAll(Pageable pageable) {
        return taiKhoanNganHangRepo.findAll(pageable);
    }

    @Override
    public TaiKhoanNganHang getOne(UUID id) {
        return taiKhoanNganHangRepo.findById(id).get();
    }
}
