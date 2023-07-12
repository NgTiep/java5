package com.example.demo.service.impl;

import com.example.demo.entity.KhachHang;
import com.example.demo.entity.PhieuGiamGia;
import com.example.demo.repository.PhieuGiamGiaRepo;
import com.example.demo.service.PhieuGiamGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PhieuGiamGiaServiceImpl implements PhieuGiamGiaService {

    @Autowired
    PhieuGiamGiaRepo phieuGiamGiaRepo;

    @Override
    public Page<PhieuGiamGia> getAll(Pageable pageable) {
        return phieuGiamGiaRepo.findAll(pageable);
    }

    @Override
    public PhieuGiamGia getOne(String maPhieu) {
        return phieuGiamGiaRepo.findById(maPhieu).get();
    }

    @Override
    public void add(PhieuGiamGia phieuGiamGia) {
        phieuGiamGiaRepo.save(phieuGiamGia);
    }

    @Override
    public void update(PhieuGiamGia phieuGiamGia) {
        phieuGiamGiaRepo.save(phieuGiamGia);

    }

    @Override
    public void delete(String maPhieu) {
        phieuGiamGiaRepo.deleteById(maPhieu);

    }

    @Override
    public Page<PhieuGiamGia> search(String ngayBatDau, String ngayKetThuc, KhachHang khachHang, Pageable pageable) {
        return phieuGiamGiaRepo.search(ngayBatDau,ngayKetThuc,khachHang,pageable);
    }
}
