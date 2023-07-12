package com.demo.service.impl;

import com.demo.entity.HoaDon;
import com.demo.entity.PhieuGiaoHang;
import com.demo.repository.PhieuGiaoHangRepo;
import com.demo.service.PhieuGiaoHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PhieuGiaoHangServiceImpl implements PhieuGiaoHangService {

    @Autowired
    PhieuGiaoHangRepo phieuGiaoHangRepo;

    @Override
    public Page<PhieuGiaoHang> getAll(Pageable pageable) {
        return phieuGiaoHangRepo.findAll(pageable);
    }

    @Override
    public PhieuGiaoHang getOne(UUID maPhieuGiao) {
        return phieuGiaoHangRepo.findById(maPhieuGiao).get();
    }

    @Override
    public void save(PhieuGiaoHang phieuGiaoHang) {
        phieuGiaoHangRepo.save(phieuGiaoHang);
    }

    @Override
    public void delete(UUID maPhieuGiao) {
        phieuGiaoHangRepo.deleteById(maPhieuGiao);
    }

    @Override
    public Page<PhieuGiaoHang> search(String ngayGiao, String ngayNhan, HoaDon hoaDon, Pageable pageable) {
        return phieuGiaoHangRepo.search("%"+ngayGiao+"%",  "%"+ngayNhan+"%", hoaDon, pageable);
    }
}
