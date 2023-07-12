package com.demo.service.impl;

import com.demo.entity.KhachHang;
import com.demo.entity.PhieuGiamGia;
import com.demo.repository.PhieuGiamGiaRepo;
import com.demo.service.PhieuGiamGiaService;
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
    public PhieuGiamGia getOne(String maphieu) {
        return phieuGiamGiaRepo.findById(maphieu).get();
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
    public void delete(String maphieu) {
        phieuGiamGiaRepo.deleteById(maphieu);

    }

    @Override
    public Page<PhieuGiamGia> search(String ngayBatDau, String ngayKetThuc, KhachHang khachHang, Pageable pageable) {
        return phieuGiamGiaRepo.search("%"+ngayBatDau+"%","%"+ngayKetThuc+"%",khachHang,pageable);
    }
}
