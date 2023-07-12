package com.demo.service.impl;

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
    public PhieuGiaoHang getOne(UUID maphieugiao) {
        return phieuGiaoHangRepo.findById(maphieugiao).get();
    }

    @Override
    public void save(PhieuGiaoHang phieuGiaoHang) {
        phieuGiaoHangRepo.save(phieuGiaoHang);
    }

    @Override
    public void delete(UUID maphieugiao) {
        phieuGiaoHangRepo.deleteById(maphieugiao);
    }
}
