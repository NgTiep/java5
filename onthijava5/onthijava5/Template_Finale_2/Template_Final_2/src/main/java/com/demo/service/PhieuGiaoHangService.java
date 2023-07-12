package com.demo.service;

import com.demo.entity.PhieuGiaoHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface PhieuGiaoHangService {

    Page<PhieuGiaoHang> getAll(Pageable pageable);

    PhieuGiaoHang getOne(UUID maphieugiao);

    void save(PhieuGiaoHang phieuGiaoHang);

    void delete(UUID maphieugiao);
}
