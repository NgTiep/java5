package com.example.btvn13.service.impl;

import com.example.btvn13.entity.TaiKhoanNganHang;
import com.example.btvn13.repository.TaiKhoanNganHangRepository;
import com.example.btvn13.service.TaiKhoanNganHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaiKhoanNganHangServiceImpl implements TaiKhoanNganHangService {

    @Autowired
    TaiKhoanNganHangRepository taiKhoanNganHangRepository;

    @Override
    public List<TaiKhoanNganHang> getAll() {
        return taiKhoanNganHangRepository.findAll();
    }

    @Override
    public TaiKhoanNganHang getOne(UUID id) {
        return taiKhoanNganHangRepository.findById(id).get();
    }
}
