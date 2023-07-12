package com.demo.service.impl;

import com.demo.entity.HangKhachHang;
import com.demo.entity.KhachHang;
import com.demo.repository.KhachHangRepo;
import com.demo.service.KhachHangService;
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
    public KhachHang getOne(Long maKH) {
        return khachHangRepo.findById(maKH).get();
    }

    @Override
    public void add(KhachHang khachHang) {
        khachHangRepo.save(khachHang);
    }

    @Override
    public void update(KhachHang khachHang) {
        khachHangRepo.save(khachHang);
    }

    @Override
    public void delete(Long maKH) {
        khachHangRepo.deleteById(maKH);
    }

    @Override
    public Page<KhachHang> search(String nhapGiaTri, HangKhachHang hangKhachHang, Pageable pageable) {
        return khachHangRepo.search("%" + nhapGiaTri + "%", hangKhachHang, pageable);
    }
}
