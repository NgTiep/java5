package com.example.demo.service;

import com.example.demo.entity.KhachHang;
import com.example.demo.entity.PhieuGiamGia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PhieuGiamGiaService {

    Page<PhieuGiamGia> getAll(Pageable pageable);

    PhieuGiamGia getOne(String ma);

    void add(PhieuGiamGia phieuGiamGia);

    void update(PhieuGiamGia phieuGiamGia);

    void delete(String ma);

    Page<PhieuGiamGia> search(String tuNgay, String denNgay, KhachHang nguoiSoHuu, Pageable pageable);

}
