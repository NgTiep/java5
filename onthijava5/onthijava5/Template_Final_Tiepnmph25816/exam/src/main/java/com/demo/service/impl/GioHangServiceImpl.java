package com.demo.service.impl;

import com.demo.entity.GioHang;
import com.demo.repository.GioHangRepo;
import com.demo.service.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GioHangServiceImpl implements GioHangService {
    @Autowired
    GioHangRepo gioHangRepo;

    @Override
    public Page<GioHang> getAll(Pageable pageable) {
        return gioHangRepo.findAll(pageable);
    }

    @Override
    public GioHang getOne(UUID maGioHang) {
        return gioHangRepo.findById(maGioHang).get();
    }

    @Override
    public void save(GioHang gioHang) {
        gioHangRepo.save(gioHang);
    }

    @Override
    public Page<GioHang> sort(Pageable pageable) {
        return gioHangRepo.sort(pageable);
    }
}
