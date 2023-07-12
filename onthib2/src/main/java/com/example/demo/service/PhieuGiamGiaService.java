package com.example.demo.service;

import com.example.demo.entity.KhachHang;
import com.example.demo.entity.PhieuGiamGia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PhieuGiamGiaService {

    Page<PhieuGiamGia> getAll(Pageable pageable);



    PhieuGiamGia getOne(String maPhieu);

    void add(PhieuGiamGia phieuGiamGia);

    void update(PhieuGiamGia phieuGiamGia);

    void delete(String maPhieu);

    Page<PhieuGiamGia> search(String ngayBatDau, String ngayKetThuc, KhachHang khachHang, Pageable pageable);

}
